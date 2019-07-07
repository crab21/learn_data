package com.example.algorithm.learnsort;

import java.util.*;

public class LearnCompare {
    public static void main(String[] args) {

        List<Users> list = new ArrayList<>();
        list.add(new Users("10","2"));
        list.add(new Users("5","2"));
        list.add(new Users("40","2"));
        list.add(new Users("3","2"));
        list.add(new Users("20","2"));
        list.add(new Users("1","2"));

        Collections.sort(list, new Comparator<Users>() {
            @Override
            public int compare(Users o1, Users o2) {
                System.out.println(Arrays.toString(o1.getId().toCharArray())+"---1--"+o1.getId());
                System.out.println(Arrays.toString(o2.getId().toCharArray())+"---2--"+o2.getId());

//                return -(Integer.valueOf(o1.getId()) > Integer.valueOf(o2.getId()) ? 1 : -1);
                int a = o1.getId().compareTo(o2.getId());
                System.out.println(a);
                if (a < 0) {
                    return 1;
                }
                return -1;
               /* int i1 = o2.getId().compareTo(o1.getId());
                System.out.println(i1);
                if (i1 < 0) {
                    return 1;
                }else{
                    return -1;
                }*/
            }
        });
        System.out.println(list);
    }
    static class Users{
        private String id;
        private String age;

        public Users(String id, String age) {
            this.id = id;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Users{" +
                    "id='" + id + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
