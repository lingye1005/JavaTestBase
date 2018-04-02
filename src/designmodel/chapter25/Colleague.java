            package designmodel.chapter25;
            /**
             * @Author: cxh
             * @CreateTime: 18/2/20 12:38
             * @ProjectName: JavaBaseTest
             */
            public abstract class Colleague {
                Mediate mediate;

                public void setMediate(Mediate mediate) {
                    this.mediate = mediate;
                }

                public abstract void send(String sendInfo);
                public abstract void receive(String getInfo);
            }
