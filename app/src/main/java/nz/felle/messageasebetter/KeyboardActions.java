package nz.felle.messageasebetter;

import android.util.Log;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Map;

/* package-private */ class KeyboardActions {
    /* package-private */ static final List<List<Map<Motion, Action>>> ACTIONS = List.of(
            // first row
            List.of(
                    // first row, first column
                    Map.of(
                            Motion.NONE, new KeyAction('e', '1'),
                            Motion.UP_LEFT, new SecondaryKeyAction('!'),
                            Motion.UP, new SecondaryKeyAction('@'),
                            Motion.UP_RIGHT, new SecondaryKeyAction('#'),
                            Motion.DOWN, new KeyAction('q', KeyAction.NONE),
                            Motion.DOWN_RIGHT, new KeyAction('w', KeyAction.NONE)
                    ),
                    // first row, second column
                    Map.of(
                            Motion.NONE, new KeyAction('r', '2'),
                            Motion.UP_LEFT, new SecondaryKeyAction('$'),
                            Motion.UP, new SecondaryKeyAction('%'),
                            Motion.UP_RIGHT, new SecondaryKeyAction('^'),
                            Motion.DOWN, new KeyAction('t', KeyAction.NONE),
                            Motion.DOWN_RIGHT, new KeyAction('y', KeyAction.NONE)
                    ),
                    // first row, third column
                    Map.of(
                            Motion.NONE, new KeyAction('i', '3'),
                            Motion.UP_LEFT, new SecondaryKeyAction('&'),
                            Motion.UP, new SecondaryKeyAction('*'),
                            Motion.UP_RIGHT, new SecondaryKeyAction('('),
                            Motion.DOWN, new KeyAction('u', KeyAction.NONE),
                            Motion.RIGHT, new SecondaryKeyAction('-'),
                            Motion.DOWN_RIGHT, new SecondaryKeyAction('+')
                    ),
                    // first row, fourth column
                    Map.of(
                            Motion.NONE, new KeyAction('o', KeyAction.NONE),
                            Motion.UP_LEFT, new SecondaryKeyAction(')'),
                            Motion.UP, new SecondaryKeyAction('_'),
                            Motion.UP_RIGHT, new SecondaryKeyAction('='),
                            Motion.LEFT, new SecondaryKeyAction('['),
                            Motion.RIGHT, new SecondaryKeyAction(']'),
                            Motion.DOWN_LEFT, new KeyAction('p', KeyAction.NONE),
                            Motion.DOWN, new SecondaryKeyAction('|'),
                            Motion.DOWN_RIGHT, new SecondaryKeyAction('\\')
                    )
            ),
            // second row
            List.of(
                    // second row, first column
                    Map.of(
                            Motion.NONE, new KeyAction('a', '4'),
                            Motion.UP, new KeyAction('á', KeyAction.NONE),
                            Motion.UP_RIGHT, new KeyAction('é', KeyAction.NONE),
                            Motion.RIGHT, new KeyAction('í', KeyAction.NONE),
                            Motion.DOWN_RIGHT, new KeyAction('ó', KeyAction.NONE),
                            Motion.DOWN, new KeyAction('ú', KeyAction.NONE)
                    ),
                    // second row, second column
                    Map.of(
                            Motion.NONE, new KeyAction('s', '5'),
                            Motion.LEFT, new KeyAction('f', KeyAction.NONE),
                            Motion.RIGHT, new KeyAction('g', KeyAction.NONE),
                            Motion.DOWN, new KeyAction('v', KeyAction.NONE),
                            Motion.DOWN_RIGHT, new KeyAction('b', KeyAction.NONE)
                    ),
                    // second row, third column
                    Map.of(
                            Motion.NONE, new KeyAction('d', '6'),
                            Motion.LEFT, new KeyAction('h', KeyAction.NONE),
                            Motion.RIGHT, new KeyAction('j', KeyAction.NONE),
                            Motion.DOWN_LEFT, new SecondaryKeyAction(','),
                            Motion.DOWN, new SecondaryKeyAction('.'),
                            Motion.DOWN_RIGHT, new SecondaryKeyAction(':')
                    ),
                    // second row, fourth column
                    Map.of(
                            Motion.NONE, new KeyAction('l', KeyAction.NONE),
                            Motion.UP_LEFT, new SecondaryKeyAction('"'),
                            Motion.UP_RIGHT, new SecondaryKeyAction('\''),
                            Motion.LEFT, new KeyAction('k', KeyAction.NONE),
                            Motion.RIGHT, new SecondaryKeyAction('?'),
                            Motion.DOWN_LEFT, new SecondaryKeyAction(';'),
                            Motion.DOWN_RIGHT, new SecondaryKeyAction('/')
                    )
            ),
            // third row
            List.of(
                    // third row, first column
                    Map.of(
                            Motion.NONE, new KeyAction('c', '7'),
                            Motion.UP, new KeyAction('z', KeyAction.NONE),
                            Motion.UP_RIGHT, new KeyAction('x', KeyAction.NONE)
                    ),
                    // third row, second column
                    // space
                    Map.of(
                            Motion.NONE, new KeyAction(' ', '8'),
                            Motion.UP, new SetCapsAction(true),
                            Motion.DOWN, new SetCapsAction(false),
                            Motion.LEFT, new Action() {
                                @Override
                                public void execute(@NonNull InputMethodView view) {
                                    view.moveCursor(-1);
                                }
                            },
                            Motion.RIGHT, new Action() {
                                @Override
                                void execute(@NonNull InputMethodView view) {
                                    view.moveCursor(1);
                                }
                            }
                    ),
                    // third row, third column
                    // space
                    Map.of(
                            Motion.NONE, new KeyAction(' ', '9'),
                            Motion.UP, new SetCapsAction(true),
                            Motion.DOWN, new SetCapsAction(false),
                            Motion.LEFT, new Action() {
                                @Override
                                public void execute(@NonNull InputMethodView view) {
                                    view.moveCursor(-1);
                                }
                            },
                            Motion.RIGHT, new Action() {
                                @Override
                                void execute(@NonNull InputMethodView view) {
                                    view.moveCursor(1);
                                }
                            }
                    ),
                    // third row, fourth column
                    Map.of(
                            Motion.NONE, new KeyAction('n', KeyAction.NONE),
                            Motion.UP, new KeyAction('ñ', KeyAction.NONE),
                            Motion.UP_LEFT, new SecondaryKeyAction('<'),
                            Motion.UP_RIGHT, new SecondaryKeyAction('>'),
                            Motion.LEFT, new KeyAction('m', KeyAction.NONE)
                    )
            ),
            // fourth row
            List.of(
                    // zero
                    Map.of(
                            Motion.NONE, new KeyAction(' ', '0')
                    ),
                    // ABC
                    Map.of(
                            Motion.NONE, new Action() {
                                private final @NonNull
                                IconShower ifNum = new IconShower(R.drawable.ic_abc_mode, false);
                                private final @NonNull
                                IconShower ifNotNum = new IconShower(R.drawable.ic_num_mode, false);

                                @Override
                                public void execute(final @NonNull InputMethodView view) {
                                    view.setNumMode(!view.getNumMode());
                                }

                                @NonNull
                                @Override
                                public ActionShower show(final @NonNull InputMethodView view) {
                                    ifNum.initialize(view);
                                    ifNotNum.initialize(view);
                                    return view.getNumMode() ? ifNum : ifNotNum;
                                }
                            },
                            Motion.UP_LEFT, new ContextMenuAction(R.drawable.ic_select_all, android.R.id.selectAll),
                            Motion.UP_RIGHT, new ContextMenuAction(R.drawable.ic_copy, android.R.id.copy),
                            Motion.DOWN_RIGHT, new ContextMenuAction(R.drawable.ic_paste, android.R.id.paste),
                            Motion.DOWN_LEFT, new ContextMenuAction(R.drawable.ic_cut, android.R.id.cut),
                            Motion.LEFT, new CustomAction(R.drawable.ic_go_to_start) {
                                @Override
                                public void execute(final @NonNull InputMethodView view) {
                                    view.doWord(Direction.BEFORE, false);
                                }
                            },
                            Motion.RIGHT, new CustomAction(R.drawable.ic_go_to_end) {
                                @Override
                                public void execute(final @NonNull InputMethodView view) {
                                    view.doWord(Direction.AFTER, false);
                                }
                            }
                    ),
                    Map.of(
                            Motion.NONE, new Action() {
                                private final @NonNull
                                IconShower shower = new IconShower(R.drawable.ic_backspace, false);

                                @Override
                                public void execute(final @NonNull InputMethodView view) {
                                    view.delete(-1);
                                }

                                @NonNull
                                @Override
                                public ActionShower show(final @NonNull InputMethodView view) {
                                    shower.initialize(view);
                                    return shower;
                                }
                            },
                            Motion.UP_LEFT, new Action() {
                                @Override
                                void execute(@NonNull InputMethodView view) {
                                    view.doWord(Direction.BEFORE, true);
                                }
                            },
                            Motion.UP_RIGHT, new Action() {
                                @Override
                                void execute(@NonNull InputMethodView view) {
                                    view.doWord(Direction.AFTER, true);
                                }
                            },
                            Motion.RIGHT, new Action() {
                                @Override
                                public void execute(@NonNull InputMethodView view) {
                                    view.delete(1);
                                }
                            },
                            Motion.UP, new CustomAction(R.drawable.ic_microphone) {
                                @Override
                                void execute(final @NonNull InputMethodView view) {
                                    view.takeVoiceInput();
                                }
                            },
                            Motion.DOWN, new CustomAction(R.drawable.ic_bottom_panel_close) {
                                @Override
                                void execute(final @NonNull InputMethodView view) {
                                    view.service.requestHideSelf(0);
                                }
                            }
                    ),
                    // editor action
                    Map.of(
                            Motion.NONE, new Action() {
                                @Override
                                void execute(final @NonNull InputMethodView view) {
                                    view.performActAction();
                                }

                                @NonNull
                                @Override
                                ActionShower show(final @NonNull InputMethodView view) {
                                    return view.getActShower();
                                }
                            },
                            Motion.DOWN, new SecondaryKeyAction('\n', R.drawable.ic_newline)
                    )
            )
    );

}
