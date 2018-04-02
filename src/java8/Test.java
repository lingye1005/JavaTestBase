        package java8;

        import java.util.*;
        import java.util.function.*;
        import java.util.stream.Collector;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;

        /**
         * @Author: cxh
         * @CreateTime: 17/12/14 20:47
         * @ProjectName: JavaBaseTest
         * <测试类></>
         */
        public class Test{
            public static void main(String[] args) {
                List<Album> albums=Albums.getAlbums();
                //方法引用::,获取专辑名字
                albums.stream().map(Album::getName).forEach(s-> System.out.println(s));

                //转换为其它集合,Collectors收集器的使用
                Set<Album> setAlbums=albums.stream().collect(Collectors.toSet());
                Set<Album> setAlbums2=albums.stream().collect(Collectors.toCollection(HashSet::new));//定制集合类型

                //转换为值
                //maxBy:找出成员最多的乐队
                Function<Artist,Integer> maxByFun=art->art.getMembers().size();
                Set<Artist> artists=albums.stream().map(album -> album.getMusicians().get(0)).collect(Collectors.toSet());
                Optional<Artist> maxMem=artists.stream().collect(Collectors.maxBy(Comparator.comparing(maxByFun)));
                System.out.println(maxMem.get());

                //找出一组专辑上曲目的平均数目
                double avg=albums.stream().collect(Collectors.averagingInt(alb->alb.getTracks().size()));
                System.out.println("专辑曲目平均值avg="+avg);

                //数据分块,按照专辑上曲目个数进行分类
                Map<Integer,List<Album>> albumBySize=albums.stream().
                        collect(Collectors.groupingBy(album -> album.getTracks().size()));
                albumBySize.forEach((k,v)->{
                    System.out.println("曲目个数为"+k+"的专辑为:"+v);
                });

                //字符串拼接joining
                String names=albums.stream().map(albs->albs.getName()).collect(Collectors.joining(",","[","]"));
                System.out.println("拼接字符串为:"+names);

                //downstream下游收集器:获取每个主唱的专辑名
                Map<String,List<String>> partByArt=albums.stream().collect(Collectors.groupingBy(
                   Album::getMainMusician,Collectors.mapping(Album::getName,Collectors.toList())));
                partByArt.forEach((k,v)->{
                    System.out.println("主唱="+k+" and 专辑名字="+v);
                });

                //使用reduce和StringJoiner类格式化艺术家姓名
                StringJoiner joiner=albums.get(0).getMusicians().get(0).getMembers().stream().
                        reduce(new StringJoiner(",","[","]"),StringJoiner::add,StringJoiner::merge);
                System.out.println(joiner);

                //joining收集器,非常方便,这就显得上面的方法有些笨拙
                List<String> strs=albums.get(0).getMusicians().get(0).getMembers();
                System.out.println(strs.stream().collect(Collectors.joining(",","[","]")));

                //测试自定义收集器
                List<String> nas=albums.get(0).getMusicians().get(0).getMembers();
                System.out.println(nas.stream().collect(new StringCollector(",","<<",">>")));

                //并行化计算专辑曲目的长度(并行化流操作)
                int sumLen=albums.parallelStream().flatMap(as->as.getTracks().stream()).
                           mapToInt(Track::getLength).sum();
                System.out.println("4张专辑中所有歌曲的总时长(单位:分钟):"+sumLen);

                //求投掷骰子每个点出现的次数和概率的映射
                int N=1000;//模拟次数
                double fracton=1.0/N;
                IntFunction<Integer> function=(i)->{
                    Random random=new Random();
                    int min=1,max=6;
                    //nextInt返回[0,max]的数
                    int res=random.nextInt(max)%(max-min+1)+1;//通用公式
                    return res;
                };
                Map<Integer,Double> map= IntStream.range(0,N).parallel().mapToObj(function).
                        collect(Collectors.groupingBy(i->i,Collectors.summingDouble(n->fracton)));
                map.forEach((k,v)->{
                    System.out.println("k="+k+" and value="+v);
                });

                /*并行化数组操作*/

                //1.parallePrefix,
                double[] para1=new double[20];
                Arrays.fill(para1,1);
                Arrays.parallelPrefix(para1,Double::sum);
                System.out.println("para1[19]理论值为20.0,实际值为:"+para1[19]);

                //2.paralleSetAll
                double[] para2=new double[20];
                Arrays.setAll(para2,i->i);
                System.out.println("para2[19]理论值为19.0,实际值为:"+para2[19]);

                //3.paralleSort
                double[] para3=new double[20];
                Arrays.parallelSetAll(para3,i->20-i);
                System.out.println("排序前:para3[19]="+para3[19]+",para3[0]="+para3[0]);
                Arrays.parallelSort(para3);
                System.out.println("排序后:para3[19]="+para3[19]+",para3[0]="+para3[0]);

                //计算滑动窗口的平均值,设定窗口大小n=4
                int n=4,len=20;
                double[] windowns=new double[len];
                Arrays.parallelSetAll(windowns,i->i);
                Arrays.parallelPrefix(windowns,Double::sum);
                int start=n-1;
                double[] result=IntStream.range(start,len)
                        .mapToDouble(i->{
                            double prefix=i==start?0:windowns[i-n];
                            return (windowns[i]-prefix)/n;
                        })
                        .toArray();
                Spliterator<Double> spl=Arrays.spliterator(result);
                spl.forEachRemaining(d-> System.out.print(d+","));
                System.out.println();

                //使用领域方法重构类
                //总时长统计
                ToIntFunction<Album> f1=a->a.getTracks().stream().mapToInt(Track::getLength).sum();
                int sunTime=countFeature(f1,albums);
                System.out.println("4张专辑总时长:"+sunTime);
                //歌曲数目统计
                ToIntFunction<Album> f2=a->a.getTracks().size();
                int sumMu=countFeature(f2,albums);
                System.out.println("歌曲总数:"+sumMu);

                //使用peek方法记录中间值,乐队名
                Set<String> mainMus=albums.stream().flatMap(album -> album.getMusicians().stream())
                        .map(artist -> artist.getName())
                        .peek(s1 -> System.out.println("我是peek()记录的中间值:"+s1))
                        .collect(Collectors.toSet());
                mainMus.forEach(s -> System.out.println("乐队名字:"+s));

                //利用并行流计算指定范围内的质数个数
                IntPredicate isPrime=i->{return IntStream.range(2,i)
                        .parallel().allMatch(x->i%x!=0);};
                long countRange=IntStream.range(1,100).parallel().filter(isPrime).count();
                System.out.println("[1,100]范围内质数的个数:"+countRange);

                //

            }
            //领域方法
            private static int countFeature(ToIntFunction<Album> func,List<Album> albums){
                return albums.stream().mapToInt(func).sum();
            }
        }
        //定制收集器,用于连接字符串,但是jdk8中的joining收集器已经很好了,这里只是测试自定义收集器的过程
        class StringCollector implements Collector<String,StringJoiner,String>{
            private String preFix;
            private String delimiter;
            private String endFix;

            StringCollector(String deli,String pre, String end){
                this.preFix=pre;;
                this.delimiter=deli;
                this.endFix=end;
            }
            //生产者
            @Override
            public Supplier<StringJoiner> supplier() {
                return ()->new StringJoiner(delimiter,preFix,endFix);
            }

            //将当前元素添加到收集器中
            @Override
            public BiConsumer<StringJoiner, String> accumulator() {
                return StringJoiner::add;
            }

            //收集器合并
            @Override
            public BinaryOperator<StringJoiner> combiner() {
                return StringJoiner::merge;
            }

            //返回收集操作的最终结果
            @Override
            public Function<StringJoiner, String> finisher() {
                     return StringJoiner::toString;
            }

            @Override
            public Set<Characteristics> characteristics() {
                Set<Characteristics> set=new HashSet<>();
                set.add(Characteristics.CONCURRENT);
                set.add(Characteristics.UNORDERED);
                return set;
            }
        }
