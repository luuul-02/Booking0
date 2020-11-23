package yu.ac.kr.booking0;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class Restaurant {
    public String resId;
    public String resName;
    public String resPhone;
    public String resLocationX;
    public String resLocationY;
    public String resAddress;
    public String resSeat;
    public Boolean resGroupSeat;
    public Boolean resParking;
    public Boolean resPacking;
    public Boolean resWifi;
    public Boolean resInfant;


    public Restaurant() {

    }

    public Restaurant(String resId, String resName, String resPhone, String resAddress, String resLocationX,
                      String resLocationY, String resSeat, Boolean resGroupSeat, Boolean resParking, Boolean resPacking,
                      Boolean resWifi, Boolean resInfant) {

        this.resId = resId;
        this.resName = resName;
        this.resPhone = resPhone;
        this.resLocationX = resLocationX;
        this.resLocationY = resLocationY;
        this.resAddress = resAddress;
        this.resSeat = resSeat;
        this.resGroupSeat = resGroupSeat;
        this.resParking = resParking;
        this.resPacking = resPacking;
        this.resWifi = resWifi;
        this.resInfant = resInfant;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResPhone() {
        return resPhone;
    }

    public void setResPhone(String resPhone) {
        this.resPhone = resPhone;
    }

    public String getResLocationX() {
        return resLocationX;
    }

    public void setResLocationX(String resLocationX) {
        this.resLocationX = resLocationX;
    }

    public String getResLocationY() {
        return resLocationY;
    }

    public void setResLocationY(String resLocationY) {
        this.resLocationY = resLocationY;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getResSeat() {
        return resSeat;
    }

    public void setResSeat(String resSeat) {
        this.resSeat = resSeat;
    }

    public Boolean getResGroupSeat() {
        return resGroupSeat;
    }

    public void setResGroupSeat(Boolean resGroupSeat) {
        this.resGroupSeat = resGroupSeat;
    }

    public Boolean getResParking() {
        return resParking;
    }

    public void setResParking(Boolean resParking) {
        this.resParking = resParking;
    }

    public Boolean getResPacking() {
        return resPacking;
    }

    public void setResPacking(Boolean resPacking) {
        this.resPacking = resPacking;
    }

    public Boolean getResWifi() {
        return resWifi;
    }

    public void setResWifi(Boolean resWifi) {
        this.resWifi = resWifi;
    }

    public Boolean getResInfant() {
        return resInfant;
    }

    public void setResInfant(Boolean resInfant) {
        this.resInfant = resInfant;
    }
}
