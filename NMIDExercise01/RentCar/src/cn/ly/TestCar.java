package cn.ly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCar {
    public static void main(String[] args) {
        System.out.println("-------------------欢迎使用租车系统...--------------------");
        System.out.println("序号          车辆名称 租车费用(元/(车·天)) 最大载人(人) 最大载货(吨)");

        //创建一个ArrayList存储各种车辆信息
        ArrayList<Car> cars = new ArrayList<>();
        Car car = new Car(1,"小轿车",40,4,0);
        Car van = new Car(2,"面包车",65,7,0);
        Car coach = new Car(3,"大巴车",180,20,0);
        Car lowHurdles = new Car(4,"低栏车",30,0,1.5);
        Car highHurdles = new Car(5,"高栏车",47,0,2.5);
        Car deliveryVan = new Car(6,"厢式车",80,0,4.5);
        Car japanesePickupTruck = new Car(7,"日式皮卡车",60,5,1);
        Car americanPickupTruck = new Car(8,"美式皮卡车",60,2,3);

        cars.add(car);
        cars.add(van);
        cars.add(coach);
        cars.add(lowHurdles);
        cars.add(highHurdles);
        cars.add(deliveryVan);
        cars.add(japanesePickupTruck);
        cars.add(americanPickupTruck);

        //输出各种车辆信息
        for (Car car1 : cars) {
            System.out.println(car1.getNumber()+"         "+car1.getName()+"            "+car1.getCost()+"          "+car1.getLoadPeople()+"            "+car1.getLoadGoods());
        }

        //输入租车信息
        System.out.println("--------------------------------------------------------");
        int[] num = new int[cars.size()];
        String temp ;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("请输入序号"+cars.get(i).getNumber()+"("+cars.get(i).getName()+")的租用数量:");
            //租车数不能是负数和小数
            while (true){
                temp = scanner.next();
                if(temp.contains(".") || temp.startsWith("-")){
                    System.out.println("不能输入小数或负数，请重新输入");
                    System.out.println("请输入序号"+cars.get(i).getNumber()+"("+cars.get(i).getName()+")的租用数量:");
                }
                else{
                    break;
                }
            }
            num[i] = Integer.parseInt(temp);
        }
        System.out.println("请输入租用天数:");
        int days = scanner.nextInt();

        int totalLoadPeople = 0;
        double totalLoadGoods = 0;
        int totalCost = 0;
        int totalNum = 0;

        //输出结算结果
        System.out.println("---------------------------------------------------------");
        System.out.println("结算结果如下：");
        System.out.println("您租用了以下车辆：");

        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0){
                System.out.println(cars.get(i).getName()+": "+num[i]+"辆");
                totalLoadPeople = totalLoadPeople + cars.get(i).getLoadPeople()*num[i];
                totalLoadGoods = totalLoadGoods + cars.get(i).getLoadGoods()*num[i];
                totalCost = totalCost + cars.get(i).getCost()*num[i];
                totalNum = totalNum + num[i];
            }
        }
        System.out.println("总体租车总数:"+totalNum + "辆");
        System.out.println("租"+days+"天");
        System.out.println("总体租车最大载人量:"+totalLoadPeople + "人");
        System.out.println("总体租车最大载货量:"+totalLoadGoods + "吨");
        System.out.println("总体租车费用:"+ totalCost + "元");

        //按回车结束程序
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                if(br.readLine().length() == 0){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
