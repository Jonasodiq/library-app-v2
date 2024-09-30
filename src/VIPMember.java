
class VIPMember extends User {
    public VIPMember(String name, int memberNo) {
        super(name, memberNo);
    }

    @Override
    public int getLoanPeriod() {
        return 28;  // VIP-medlemmar får 28 dagar lånetid
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
