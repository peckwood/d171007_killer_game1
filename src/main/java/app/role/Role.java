package app.role;

public enum Role {
	
	KILLER(true, 1, false)
	, SEER(true, 2, true)
	, WITCH(true, 3, true)
	, GUARDIAN(true, 4, true)
	, CIVILIAN(false, 0, false);
	
	private final boolean HAS_NIGHT_ACTION;
	private final int NIGHT_ORDER;
	private final boolean IS_GOD;
	public boolean isHAS_NIGHT_ACTION() {
		return HAS_NIGHT_ACTION;
	}
	public int getNIGHT_ORDER() {
		return NIGHT_ORDER;
	}
	private Role(boolean hAS_NIGHT_ACTION, int nIGHT_ORDER, boolean iS_GOD) {
		HAS_NIGHT_ACTION = hAS_NIGHT_ACTION;
		NIGHT_ORDER = nIGHT_ORDER;
		IS_GOD = iS_GOD;
	}
	public boolean isIS_GOD() {
		return IS_GOD;
	}
	
	
}
