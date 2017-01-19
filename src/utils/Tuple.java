package utils;

public class Tuple<X, Y> {
	public final X currentLoc;
	public final Y targetLoc;

	public Tuple(X currentLoc, Y targetLoc) {
		this.currentLoc = currentLoc;
		this.targetLoc = targetLoc;
	}
}