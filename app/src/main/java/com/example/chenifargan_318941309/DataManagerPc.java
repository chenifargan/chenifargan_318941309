package com.example.chenifargan_318941309;

import java.util.ArrayList;

public class DataManagerPc {
    public static ArrayList<Product> generateMovies() {

        ArrayList<Product> products = new ArrayList<>();


        products.add(new Product()
                .setProduct("Macbook")
                .setImage("https://www.payngo.co.il/media/catalog/product/cache/6b2f4d2b8c238597c4864fc429fa65dd/1/_/1_42_87.jpg")
                .setDuration(142)
                .setRating(87)
        );

       products.add(new Product()
                .setProduct("Lenovo")
                .setImage("https://www.cubeex.co.il/wp-content/uploads/2021/04/lenovo-2.png")
                .setDuration(97)
                .setRating(72)
        );

        products.add(new Product()
                .setProduct("Microsoft")
                .setImage("https://creatixcdn.azureedge.net/fetch/pc365/w_1900,v_13/https://www.pc365.co.il/images/image(7).jpg")
                .setDuration(104)
                .setRating(78)
        );


        products.add(new Product()
                .setProduct("dress")
                .setImage("https://litb-cgis.rightinthebox.com/images/640x640/201812/lkrbkp1545209214562.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Events Dress")
                .setImage("https://www.sounique.co.il/wp-content/uploads/2020/08/4309.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Evening dress")
                .setImage("https://www.april-fashion.com/wp-content/uploads/2021/03/013339.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Pink headphones")
                .setImage("https://www.dominator.co.il/images/itempics/6031_13052021135632_large.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Bluetooth earphones")
                .setImage("https://tribit.co.il/wp-content/uploads/2020/09/15904628771307.png")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Coat")
                .setImage("https://www.e-shetach.co.il/wp-content/uploads/2019/11/caribou_grey2.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Evening coat")
                .setImage("https://litb-cgis.rightinthebox.com/images/640x640/202109/bps/product/inc/nuacfg1631772251334.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Shoes")
                .setImage("https://d3m9l0v76dty0.cloudfront.net/system/photos/6042126/large/31dfafd58d2646bc35cef4bc03047fe8.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("heels")
                .setImage("https://www.togonline.co.il/images/site/products/111829-01-3.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("Evening coat")
                .setImage("https://litb-cgis.rightinthebox.com/images/640x640/202109/bps/product/inc/nuacfg1631772251334.jpg")
                .setDuration(104)
                .setRating(78)
        );
        products.add(new Product()
                .setProduct("shirt")
                .setImage("https://www.wawa.co.il/files/products/image1_646_2015-12-23_17-03-59.jpg")
                .setDuration(104)
                .setRating(78)
        );



        return products;
}


}
