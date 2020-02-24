package com.lh.list;

import com.google.gson.Gson;
import com.lh.list.model.CardCRCModel;
import com.lh.list.model.FaceCRCModel;
import lh.toolclass.LHCRC32;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ListApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ListApplication.class, args);
//        System.out.println("http://localhost:8080/swagger-ui.html");

//        得到RFID的CRC码
        CardCRCModel cardCRCModel = new CardCRCModel();
        cardCRCModel.setCardId("AAAAAAAAAAAAAAAASSSSSSSSSSSSSS");
        cardCRCModel.setEndDays(new Date());
        final String cardCRC = getCRCCode(cardCRCModel);
        System.out.println("cardCRC:" + cardCRC);

//        得到脸照的CRC码
        List<String> pictureList = new ArrayList<>();
        pictureList.add("AAAAAAAAAAAAAAAASSSSSSSSSSSSSS");
        pictureList.add("AAAAAAAAAAAAAAAATTTTTTTTTTTTTT");
        pictureList.add("AAAAAAAAAAAAAYYYYYYYYYYYYYYYYY");
        pictureList.add("AAAAAAAAAAAAYYYYYYYYYYYYYYYYUU");
        FaceCRCModel faceCRCModel = new FaceCRCModel();
        faceCRCModel.setPersonId("personIDpersonIDAAAAAAAAAAAAAAAAA");
        faceCRCModel.setEndDays(new Date());
        faceCRCModel.setPictureIdList(pictureList);
        final String faceCRC = getCRCCode(faceCRCModel);
        System.out.println("faceCRC:" + faceCRC);
    }

    /**
     * 得到CRC码
     *
     * @param data 数据对象
     * @param <T>  泛型
     * @return CRC码
     */
    private static <T> String getCRCCode(T data) {
        Gson gson = new Gson();
        final String s = gson.toJson(data);
        final long encrypt = LHCRC32.encrypt(s);
        return String.valueOf(encrypt);
    }

}
