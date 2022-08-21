package nz.felle.messageasebetter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract class Action {
	public static final char NONE = '\0';

	abstract void execute(@NonNull InputMethodView view);

	boolean executeLongPress(final @NonNull InputMethodView view) {
		return false;
	}

	@Nullable	ActionShower show(final @NonNull InputMethodView view) {
		return null;
	}

	boolean secondary() {
		return false;
	}
}
