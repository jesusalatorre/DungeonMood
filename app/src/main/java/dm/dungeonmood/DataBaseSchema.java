package dm.dungeonmood;

/**
 * Created by Jesus on 4/5/2019.
 */
import android.provider.BaseColumns;

public final class DataBaseSchema {
    private DataBaseSchema() {
    }

    public static class SoundsTable implements BaseColumns {
        public static final String TABLE_NAME = "Sounds";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DETAILS = "details";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_URL = "url";
    }

    public static class SpellsTable implements BaseColumns {
        public static final String TABLE_NAME = "Spells";
        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_NAME_SCHOOL = "school";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}