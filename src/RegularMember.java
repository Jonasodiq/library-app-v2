
class RegularMember extends User {
    public RegularMember(String name, int memberNo) {
        super(name, memberNo);
    }

    @Override
    public int getLoanPeriod() {
        return 14;  // Vanliga medlemmar får 14 dagar lånetid
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}