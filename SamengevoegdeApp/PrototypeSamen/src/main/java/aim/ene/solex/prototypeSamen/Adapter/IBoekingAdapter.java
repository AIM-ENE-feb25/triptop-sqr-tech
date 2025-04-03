package aim.ene.solex.prototypeSamen.Adapter;

import aim.ene.solex.prototypeSamen.Domain.Boeking;

public interface IBoekingAdapter {
    String maakBoeking(Boeking boeking);
    String getNaam();
}
