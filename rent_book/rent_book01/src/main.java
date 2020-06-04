import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/**
 * @author ly
 * @date 2020
 **/
public class main {
    static int max = 3;//最大图书数量
    static int reserved = 1;//图书馆现有图书数量
    static int rented = 2;//借出去的图书数量

    public static void main(String[] args) {

        Runnable returnBook = new Runnable() { //还书的Runnable实现类
            @Override
            public void run() {
                synchronized (this) { //使用锁，增加安全性
                    if (reserved == 3) {
                        System.out.println("无需还书");


                    } else {
                        rented--;
                        reserved++;
                        System.out.println("图书馆剩余库存："+ reserved);
                    }
                }
            }
        };

        Runnable rentBook = new Runnable() {//借书的Runnable实现类
            @Override
            public void run() {
                synchronized (this) {
                    while (true) {
                        if (reserved == 0) {
                            try {
                                this.wait(100);//没有书可借，就等待100ms，同时释放锁，直到有书可借
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            break;
                        }
                    }

                    rented++;
                    reserved--;
                    System.out.println("图书馆剩余库存："+ reserved);
                }
            }
        };

        //启动借书还书线程，进行模拟
        new Thread(rentBook).start();
        new Thread(rentBook).start();
        new Thread(returnBook).start();
        new Thread(returnBook).start();
        new Thread(returnBook).start();
        new Thread(returnBook).start();
        new Thread(rentBook).start();
        new Thread(rentBook).start();
        new Thread(rentBook).start();

        new Thread(returnBook).start();
    }
}
