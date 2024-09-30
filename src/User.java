

abstract class User implements Comparable<User> {
    private final String name;
    private final int memberNo;

    public User(String name, int memberNo) {
        this.name = name;
        this.memberNo = memberNo;
    }

    public String getName() {
        return name;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public abstract int getLoanPeriod();

}