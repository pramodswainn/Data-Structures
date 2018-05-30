class MobilePhoneException extends Exception {
    private static final long serialVersionUID = 3L;

    MobilePhoneException(String s) {
        super(s);
    }
}

public class MobilePhone {

    int id;
    boolean status;
    Exchange location;

    public MobilePhone(int num) {
        this.id = num;
        this.status = false;
    }

    public MobilePhone(int num, Exchange e) {
        this.id = num;
        this.status = true;
        this.location = e;
        e.mobset.a.insert(this);
        MobilePhone mp = this;
        Exchange p = e.parent();
        if (p != null) {
            while (p != null) {
                p.mobset.a.insert(mp);
                p = p.parent;
            }
        }
    }

    public int number() {
        return this.id;
    }

    public String status() {
        if (this.status) {
            return "On";
        } 
        else return "Off";
    }

    public Exchange location() throws MobilePhoneException {
        if (this.status) {
            return this.location;
        } 
        else throw new MobilePhoneException("Phone is Switched off");
    }

    public void switchOn() {
        if (this.status) {
            System.out.println("Device is already On");
        } 
        else {
            this.status = true;
        }
    }

    public void switchOff() {
        if (!this.status) {
            System.out.println("Device is already Off");
        } else {
            this.status = false;
        }
    }
}
