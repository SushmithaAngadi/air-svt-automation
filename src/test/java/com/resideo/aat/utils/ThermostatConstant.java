package com.resideo.utils.aat;

public class ThermostatConstant {

	public enum SystemSwitch {
		HEAT(0), 
		COOL(1), 
		AUTO(2), 
		OFF(3);

		public final int value;

		SystemSwitch(int value) {
			this.value = value;
		}

		public static SystemSwitch fromValue(int value) {
			for (SystemSwitch s : values()) {
				if (s.value == value)
					return s;
			}
			throw new IllegalArgumentException("Invalid SystemSwitch value: " + value);
		}
	}

	public enum ChangeMsgId {
		BUTTON_STATE_CHANGE(0),
		POWER_STATE_CHANGE(7),
		DATE_TIME_CHANGE(9),
		SYSTEM_MODE_CHANGE(12),
		DISABLE_PHANTOM_CHANGE(13),
		BACKLIGHT_CHANGE(14),
		INTERNAL_HUM_CHANGE(16),
		BATTERY_STATE_CHANGE(17),
		AC_POWER_STATE_CHANGE(18),
		PHYSICAL_RELAYS_CHANGE(20),
		ISU_CHANGE(21),
		RESET_CHANGE(22),
		SETPOINT_CHANGE(23),
		OVERRIDE_HUB_FAILSAFE_STATE(24),
		ALERT_CHANGE(28),
		SCHEDULE_CHANGE(41),
		HOLD_CHANGE(42),
		TEMPERATURE_CHANGE(91);
		
		public final int value;

		ChangeMsgId(int value) {
			this.value = value;
		}

		public static ChangeMsgId fromValue(int value) {
			for (ChangeMsgId id : values()) {
				if (id.value == value)
					return id;
			}
			throw new IllegalArgumentException("Unknown ChangeMsgId: " + value);
		}
	}

	public enum QueryMsgId {
		SCREEN_QUERY(1),
		PHYSICAL_RELAYS_QUERY(2),
		POWER_STATE_QUERY(10),
		DATE_TIME_QUERY(12),
		SYSTEM_MODE_QUERY(17),
		INTERNAL_HUM_QUERY(19),
		BATTERY_STATE_QUERY(22),
		AC_POWER_STATE_QUERY(23),
		ISU_QUERY(24),
		SETPOINT_QUERY(27),
		ALERT_QUERY(32),
		SCHEDULE_QUERY(37),
		HOLD_QUERY(38),
		BACKLIGHT_QUERY(39),
		TEMPERATURE_QUERY(90);

		public final int value;

		QueryMsgId(int value) {
			this.value = value;
		}

		public static QueryMsgId fromValue(int value) {
			for (QueryMsgId id : values()) {
				if (id.value == value)
					return id;
			}
			throw new IllegalArgumentException("Unknown QueryMsgId: " + value);
		}
	}

	public enum ResponseMsgId {
		SCREEN_RESPONSE(1),
		PHYSICAL_RELAYS_RESPONSE(2),
		POWER_STATE_RESPONSE(10),
		DATE_TIME_RESPONSE(12),
		CHANGE_ACK_RESPONSE(17),
		SYSTEM_MODE_RESPONSE(18),
		INTERNAL_HUM_RESPONSE(20),
		BATTERY_STATE_RESPONSE(23),
		AC_POWER_STATE_RESPONSE(24),
		ISU_RESPONSE(25),
		SETPOINT_RESPONSE(28),
		ALERT_RESPONSE(33),
		SCHEDULE_RESPONSE(55),
		HOLD_RESPONSE(56),
		BACKLIGHT_RESPONSE(57),
		TEMPERATURE_RESPONSE(92),
		NEGATIVE_RESPONSE_NACK(127);

		public final int value;

		ResponseMsgId(int value) {
			this.value = value;
		}

		public static ResponseMsgId fromValue(int value) {
			for (ResponseMsgId id : values()) {
				if (id.value == value)
					return id;
			}
			throw new IllegalArgumentException("Unknown ResponseMsgId: " + value);
		}
	}

	public static final class UI {
		private UI() {
		}

		public static final String DARK_MODE = "dark";
		public static final String LIGHT_MODE = "light";
		public static final String SYSTEM_MODE = "system";

		public enum AppearanceMode {
			DARK(DARK_MODE), 
			LIGHT(LIGHT_MODE), 
			SYSTEM(SYSTEM_MODE);

			public final String value;

			AppearanceMode(String value) {
				this.value = value;
			}

			public static AppearanceMode fromValue(String v) {
				if (v == null)
					throw new IllegalArgumentException("AppearanceMode is null");
				String s = v.trim().toLowerCase();
				for (AppearanceMode m : values()) {
					if (m.value.equals(s))
						return m;
				}
				throw new IllegalArgumentException("Invalid AppearanceMode: " + v);
			}
		}
	}

	public static final class MCI {
		private MCI() {
		}

		public static final byte HEADER = 0x5B; // '['
		public static final byte STUFF_PREFIX = 0x25; // '%'
		public static final byte[] HEADER_REPLACE = new byte[] { 0x25, 0x5E }; // %^
		public static final byte[] STUFF_PREFIX_REPLACE = new byte[] { 0x25, 0x2A }; // %*
		public static final byte[] MCI_RESET = new byte[] { '[', 'C', '(', '1', ')' };
		public static final byte[] MCI_RESET_RESPONSE = new byte[] { '[', 'C', '(', '0', ')' };
		public static final byte AUTOMATED_TEST = 0x32; // '2'
	}

	public static final class AAT {
		private AAT() {
		}

		public static final byte HEADER = 0x3C; // '<'
		public static final byte FOOTER = 0x3E; // '>'
		public static final byte STUFF_PREFIX = 0x31; // '1'

		public static final byte[] HEADER_REPLACE = new byte[] { 0x31, (byte) 0xC3 }; // 31 C3
		public static final byte[] FOOTER_REPLACE = new byte[] { 0x31, (byte) 0xC1 }; // 31 C1
		public static final byte[] STUFF_PREFIX_REPLACE = new byte[] { 0x31, (byte) 0xCE }; // 31 CE

		public static final byte MSG_TYPE = 0x00;
		public static final byte CPU_ID = 0x00;

		public static final int HEADER_IDX = 0;
		public static final int MSG_TYPE_IDX = 1;
		public static final int CPU_ID_IDX = 2;
		public static final int MSG_NUMBER_IDX = 3;
		public static final int MSG_ID_TYPE_IDX = 4;
		public static final int MSG_ID_IDX = 5;
		public static final int ANCILLARY_COUNT_IDX = 7;
		public static final int ANCILLARY_DATA_IDX = 9;

		public static final int AAT_MIN_FRAME_LEN = 11;
		public static final int AAT_MAX_FRAME_LEN = 171;
		public static final int AAT_CLEAR_DATA_TIMEOUT_SEC = 1;

		public enum MSG_ID_TYPE {
			CHANGE(0), 
			QUERY(1), 
			RESPONSE(2), 
			EVENT(3);

			public final int value;

			MSG_ID_TYPE(int value) {
				this.value = value;
			}

			public static MSG_ID_TYPE fromValue(int v) {
				for (MSG_ID_TYPE t : values()) {
					if (t.value == v)
						return t;
				}
				throw new IllegalArgumentException("Invalid MSG_ID_TYPE: " + v);
			}
		}

		public enum A_MsgFrameByteIndex {
			_0_MsgType(0),
			_1_MsgToFrom(1),
			_2_MsgNumber(2),
			_3_MsgIdType(3),
			_4_MsgId(4),
			_5_MsgId(5),
			_6_AncillaryCount(6),
			_7_AncillaryCount(7),
			_8_FirstDataByte(8);

			public final int idx;

			A_MsgFrameByteIndex(int idx) {
				this.idx = idx;
			}
		}
	}
	
	public enum ResetType {
		DEFAULT_NVM(0), PRESERVE_NVM(1), FACTORY(2);

		public final int value;

		ResetType(int value) {
			this.value = value;
		}

		public static int fromText(String text) {
			if (text == null) {
				throw new IllegalArgumentException("Reset command is null");
			}

			String cmd = text.toUpperCase().trim();

			if (cmd.contains("DEFAULT")) {
				return DEFAULT_NVM.value;
			}
			if (cmd.contains("PRESERVE")) {
				return PRESERVE_NVM.value;
			}
			if (cmd.contains("FACTORY")) {
				return FACTORY.value;
			}

			throw new IllegalArgumentException("Invalid RESET command: " + text);
		}
	}

	public enum EventMsgId {
		AAT_STAT_RESET_E(24);

		public final int value;

		EventMsgId(int value) {
			this.value = value;
		}
	}

}