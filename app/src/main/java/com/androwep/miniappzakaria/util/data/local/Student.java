package com.androwep.miniappzakaria.util.data.local;

public class Student {
    private int id;
    private String name;
    private int dep_id;
    private String category;
    private String price;
    private String discreption;

    public Student() {
    }

    public Student(int id, String name, int dep_id, String category, String price,String discreption) {
        this.id = id;
        this.name = name;
        this.dep_id = dep_id;
        this.category = category;
        this.price = price;
        this.price = discreption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }
    //
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getDep_id() {
//        return dep_id;
//    }
//
//    public void setDep_id(int dep_id) {
//        this.dep_id = dep_id;
//    }



//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", dep_id=" + dep_id +
//                '}';
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dep_id=" + dep_id +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", discreption='" + discreption + '\'' +
                '}';
    }
}
