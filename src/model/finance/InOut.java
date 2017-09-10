package model.finance;

/**
 * Created by JerryCheng on 2017.7.14.
 */
public class InOut {
    String begin;
    String end;
    String type;
    String paytype;
    String id;

    public InOut(String begin, String end, String type, String paytype, String id) {
        this.begin = begin;
        this.end = end;
        this.type = type;
        this.paytype = paytype;
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}