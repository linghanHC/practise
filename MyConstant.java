package ca.hockey.wet;

public class MyConstant {

		final public static String CONS = "Y";

        // test 2
		public enum AppType {
			TRADITIONAL((short) 26),
			UNTRADITIONAL((short) 67);

			private final short appTypeId;

			AppType(short appTypeId) {
				this.appTypeId = appTypeId;
			}

			public short getAppTypeId() {
				return appTypeId;
			}

		}

		public enum ENTITY_GET_DEFAULT_PARAMETER {
			RelatedIndicator,
			UnrelatedIndicator
		}
}
