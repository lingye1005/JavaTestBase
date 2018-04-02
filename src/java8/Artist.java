        package java8;

        import java.util.ArrayList;
        import java.util.List;

        /**
         * @Author: cxh
         * @CreateTime: 17/12/14 20:37
         * @ProjectName: JavaBaseTest
         * <创作音乐的个人或者团队></>
         */
        public class Artist {
            String name;//艺术家的名字
            List<String> members;//乐队成员
            String original;//乐队来自哪里

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getMembers() {
                return members;
            }

            public void setMembers(ArrayList<String> members) {
                this.members = members;
            }

            Artist(String name,List<String> members,String original){
                this.name=name;
                this.members=members;
                this.original=original;
            }

            //

            //toString
            @Override
            public String toString() {
                return "Artist{" +
                        "name='" + name + '\'' +
                        ", members=" + members +
                        ", original='" + original + '\'' +
                        '}';
            }

        }
