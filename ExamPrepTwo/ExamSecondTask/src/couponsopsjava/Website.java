package couponsopsjava;

import java.util.ArrayList;
import java.util.List;

public class Website {

    public String domain;
    public int usersCount;
    public List<Coupon> coupons;

    public Website(String domain, int usersCount) {
        this.domain = domain;
        this.usersCount = usersCount;
        this.coupons = new ArrayList<>();
    }

    public String getDomain() {
        return domain;
    }

    public Website setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public Website setUsersCount(int usersCount) {
        this.usersCount = usersCount;
        return this;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public Website setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
        return this;
    }



}
