        package java8;

        /**
         * @Author: cxh
         * @CreateTime: 17/12/14 20:38
         * @ProjectName: JavaBaseTest
         * <专辑中的一支曲目></>
         */
        public class Track {
            String name;//曲目名称
            int length;//曲目时常
            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            Track(String name, int len){
                this.name=name;
                this.length=len;
            }

            //toString

            @Override
            public String toString() {
                return "Track{" +
                        "name='" + name + '\'' +
                        ", length=" + length +
                        '}';
            }
        }
