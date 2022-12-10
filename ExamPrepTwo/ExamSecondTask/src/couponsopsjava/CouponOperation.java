package couponsopsjava;

import java.util.*;
import java.util.stream.Collectors;


public class CouponOperation implements ICouponOperation {

    private Map<String, Website> websites;
    private Map<String, Coupon> coupons;

    public CouponOperation() {
        this.websites = new HashMap<>();
        this.coupons = new HashMap<>();
    }

    public void registerSite(Website w) {
        if (exist(w)) {
            throw new IllegalArgumentException();
        }
        this.websites.put(w.domain, w);
    }

    public void addCoupon(Website w, Coupon c) {
        if (!exist(w)) {
            throw new IllegalArgumentException();
        }

            c.setWebsite(w);

        this.coupons.put(c.code, c);
        if (!w.coupons.contains(c)) {
            w.coupons.add(c);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Website removeWebsite(String domain) {
        Website website = findWebSiteWithDomain(domain);
        if (website == null) {
            throw new IllegalArgumentException();
        }

            website.coupons.forEach(c-> this.coupons.remove(c.code,c));
            this.websites.remove(website.domain,website);
//            removeAllCouponsWithWebsite(website);

        return website;
    }

    public Coupon removeCoupon(String code) {
        Coupon coupon = findCouponWithCode(code);
        if (coupon == null) {
            throw new IllegalArgumentException();
        }
            this.coupons.remove(coupon.code,coupon);
            this.websites.values().stream().forEach(website -> website.coupons.remove(coupon));

        return coupon;
    }

    public boolean exist(Website w) {

        return this.websites.containsKey(w.domain);
    }

    public boolean exist(Coupon c) {

        return this.coupons.containsKey(c.code);
    }

    public Collection<Website> getSites() {
        return this.websites.isEmpty() ? Collections.emptyList() :
                this.websites.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public Collection<Coupon> getCouponsForWebsite(Website w) {
        if (!exist(w)) {
            throw new IllegalArgumentException();
        }

        return w.coupons;
    }

    public void useCoupon(Website w, Coupon c) {
        if (!exist(c) || !exist(w) || !c.getWebsite().equals(w)) {
            throw new IllegalArgumentException();
        }
        w.coupons.remove(c);
        this.coupons.remove(c.code,c);
    }

    public Collection<Coupon> getCouponsOrderedByValidityDescAndDiscountPercentageDesc() {
        return this.coupons.values().stream().sorted((c1, c2) -> {
            int result = Integer.compare(c2.validity, c1.validity);
            if (result == 0) {
                result = Integer.compare(c2.discountPercentage, c1.discountPercentage);
            }
            return result;
        }).collect(Collectors.toList());
    }

    public Collection<Website> getWebsitesOrderedByUserCountAndCouponsCountDesc() {
        return this.websites.values().stream().sorted((w1, w2) -> {
            int result = Integer.compare(w1.usersCount, w2.usersCount);
            if (result == 0) {
                result = Integer.compare(w2.coupons.size(), w1.coupons.size());
            }
            return result;
        }).collect(Collectors.toList());
    }

    private void removeAllCouponsWithWebsite(Website website) {
        this.coupons.values().stream().filter(coupon -> coupon.website.domain.equals(website.domain)).forEach(c -> this.removeCoupon(c.code));
    }

    private Website findWebSiteWithDomain(String domain) {
        return this.websites.values().stream().filter(w -> w.domain.equals(domain)).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }

    private Coupon findCouponWithCode(String code) {
        return this.coupons.values().stream().filter(c -> c.code.equals(code)).collect(Collectors.toList()).get(0);
    }
}
