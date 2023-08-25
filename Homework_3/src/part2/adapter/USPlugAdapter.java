package part2.adapter;

public class USPlugAdapter extends AmericanPlug{
    private EuropeanPlug plug;

    public USPlugAdapter(EuropeanPlug plug) {
        this.plug = plug;
    }
    @Override
    public void plugIn() {
        System.out.println("Адаптер работает.");
        plug.plugIn();
    }
}
