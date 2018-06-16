package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RealmAlarmRealmProxy extends com.rocklobstre.parrot.data.realmmodel.RealmAlarm
    implements RealmObjectProxy, RealmAlarmRealmProxyInterface {

    static final class RealmAlarmColumnInfo extends ColumnInfo
        implements Cloneable {

        public long alarmIdIndex;
        public long alarmTitleIndex;
        public long activeIndex;
        public long vibrateOnlyIndex;
        public long renewAutomaticallyIndex;
        public long hourOfDayIndex;
        public long minuteIndex;

        RealmAlarmColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.alarmIdIndex = getValidColumnIndex(path, table, "RealmAlarm", "alarmId");
            indicesMap.put("alarmId", this.alarmIdIndex);
            this.alarmTitleIndex = getValidColumnIndex(path, table, "RealmAlarm", "alarmTitle");
            indicesMap.put("alarmTitle", this.alarmTitleIndex);
            this.activeIndex = getValidColumnIndex(path, table, "RealmAlarm", "active");
            indicesMap.put("active", this.activeIndex);
            this.vibrateOnlyIndex = getValidColumnIndex(path, table, "RealmAlarm", "vibrateOnly");
            indicesMap.put("vibrateOnly", this.vibrateOnlyIndex);
            this.renewAutomaticallyIndex = getValidColumnIndex(path, table, "RealmAlarm", "renewAutomatically");
            indicesMap.put("renewAutomatically", this.renewAutomaticallyIndex);
            this.hourOfDayIndex = getValidColumnIndex(path, table, "RealmAlarm", "hourOfDay");
            indicesMap.put("hourOfDay", this.hourOfDayIndex);
            this.minuteIndex = getValidColumnIndex(path, table, "RealmAlarm", "minute");
            indicesMap.put("minute", this.minuteIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final RealmAlarmColumnInfo otherInfo = (RealmAlarmColumnInfo) other;
            this.alarmIdIndex = otherInfo.alarmIdIndex;
            this.alarmTitleIndex = otherInfo.alarmTitleIndex;
            this.activeIndex = otherInfo.activeIndex;
            this.vibrateOnlyIndex = otherInfo.vibrateOnlyIndex;
            this.renewAutomaticallyIndex = otherInfo.renewAutomaticallyIndex;
            this.hourOfDayIndex = otherInfo.hourOfDayIndex;
            this.minuteIndex = otherInfo.minuteIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final RealmAlarmColumnInfo clone() {
            return (RealmAlarmColumnInfo) super.clone();
        }

    }
    private RealmAlarmColumnInfo columnInfo;
    private ProxyState<com.rocklobstre.parrot.data.realmmodel.RealmAlarm> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("alarmId");
        fieldNames.add("alarmTitle");
        fieldNames.add("active");
        fieldNames.add("vibrateOnly");
        fieldNames.add("renewAutomatically");
        fieldNames.add("hourOfDay");
        fieldNames.add("minute");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    RealmAlarmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmAlarmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rocklobstre.parrot.data.realmmodel.RealmAlarm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$alarmId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.alarmIdIndex);
    }

    @Override
    public void realmSet$alarmId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'alarmId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$alarmTitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.alarmTitleIndex);
    }

    @Override
    public void realmSet$alarmTitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.alarmTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.alarmTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.alarmTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.alarmTitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$active() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.activeIndex);
    }

    @Override
    public void realmSet$active(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.activeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.activeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$vibrateOnly() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.vibrateOnlyIndex);
    }

    @Override
    public void realmSet$vibrateOnly(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.vibrateOnlyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.vibrateOnlyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$renewAutomatically() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.renewAutomaticallyIndex);
    }

    @Override
    public void realmSet$renewAutomatically(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.renewAutomaticallyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.renewAutomaticallyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$hourOfDay() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.hourOfDayIndex);
    }

    @Override
    public void realmSet$hourOfDay(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.hourOfDayIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.hourOfDayIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$minute() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.minuteIndex);
    }

    @Override
    public void realmSet$minute(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.minuteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.minuteIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("RealmAlarm")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("RealmAlarm");
            realmObjectSchema.add("alarmId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("alarmTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("active", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("vibrateOnly", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("renewAutomatically", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("hourOfDay", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("minute", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("RealmAlarm");
    }

    public static RealmAlarmColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_RealmAlarm")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'RealmAlarm' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_RealmAlarm");
        final long columnCount = table.getColumnCount();
        if (columnCount != 7) {
            if (columnCount < 7) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final RealmAlarmColumnInfo columnInfo = new RealmAlarmColumnInfo(sharedRealm.getPath(), table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'alarmId' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.alarmIdIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field alarmId");
            }
        }

        if (!columnTypes.containsKey("alarmId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'alarmId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("alarmId") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'alarmId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.alarmIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'alarmId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("alarmId"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'alarmId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("alarmTitle")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'alarmTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("alarmTitle") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'alarmTitle' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.alarmTitleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'alarmTitle' is required. Either set @Required to field 'alarmTitle' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("active")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'active' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("active") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'active' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.activeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'active' does support null values in the existing Realm file. Use corresponding boxed type for field 'active' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("vibrateOnly")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'vibrateOnly' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("vibrateOnly") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'vibrateOnly' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.vibrateOnlyIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'vibrateOnly' does support null values in the existing Realm file. Use corresponding boxed type for field 'vibrateOnly' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("renewAutomatically")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'renewAutomatically' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("renewAutomatically") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'renewAutomatically' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.renewAutomaticallyIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'renewAutomatically' does support null values in the existing Realm file. Use corresponding boxed type for field 'renewAutomatically' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("hourOfDay")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'hourOfDay' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("hourOfDay") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'hourOfDay' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.hourOfDayIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'hourOfDay' does support null values in the existing Realm file. Use corresponding boxed type for field 'hourOfDay' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("minute")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'minute' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("minute") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'minute' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.minuteIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'minute' does support null values in the existing Realm file. Use corresponding boxed type for field 'minute' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_RealmAlarm";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.rocklobstre.parrot.data.realmmodel.RealmAlarm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rocklobstre.parrot.data.realmmodel.RealmAlarm obj = null;
        if (update) {
            Table table = realm.getTable(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("alarmId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("alarmId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmAlarmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("alarmId")) {
                if (json.isNull("alarmId")) {
                    obj = (io.realm.RealmAlarmRealmProxy) realm.createObjectInternal(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmAlarmRealmProxy) realm.createObjectInternal(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class, json.getString("alarmId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'alarmId'.");
            }
        }
        if (json.has("alarmTitle")) {
            if (json.isNull("alarmTitle")) {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$alarmTitle(null);
            } else {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$alarmTitle((String) json.getString("alarmTitle"));
            }
        }
        if (json.has("active")) {
            if (json.isNull("active")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'active' to null.");
            } else {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$active((boolean) json.getBoolean("active"));
            }
        }
        if (json.has("vibrateOnly")) {
            if (json.isNull("vibrateOnly")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'vibrateOnly' to null.");
            } else {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$vibrateOnly((boolean) json.getBoolean("vibrateOnly"));
            }
        }
        if (json.has("renewAutomatically")) {
            if (json.isNull("renewAutomatically")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'renewAutomatically' to null.");
            } else {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$renewAutomatically((boolean) json.getBoolean("renewAutomatically"));
            }
        }
        if (json.has("hourOfDay")) {
            if (json.isNull("hourOfDay")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hourOfDay' to null.");
            } else {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$hourOfDay((int) json.getInt("hourOfDay"));
            }
        }
        if (json.has("minute")) {
            if (json.isNull("minute")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minute' to null.");
            } else {
                ((RealmAlarmRealmProxyInterface) obj).realmSet$minute((int) json.getInt("minute"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rocklobstre.parrot.data.realmmodel.RealmAlarm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.rocklobstre.parrot.data.realmmodel.RealmAlarm obj = new com.rocklobstre.parrot.data.realmmodel.RealmAlarm();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("alarmId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$alarmId(null);
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$alarmId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("alarmTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$alarmTitle(null);
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$alarmTitle((String) reader.nextString());
                }
            } else if (name.equals("active")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'active' to null.");
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$active((boolean) reader.nextBoolean());
                }
            } else if (name.equals("vibrateOnly")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'vibrateOnly' to null.");
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$vibrateOnly((boolean) reader.nextBoolean());
                }
            } else if (name.equals("renewAutomatically")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'renewAutomatically' to null.");
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$renewAutomatically((boolean) reader.nextBoolean());
                }
            } else if (name.equals("hourOfDay")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hourOfDay' to null.");
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$hourOfDay((int) reader.nextInt());
                }
            } else if (name.equals("minute")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minute' to null.");
                } else {
                    ((RealmAlarmRealmProxyInterface) obj).realmSet$minute((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'alarmId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.rocklobstre.parrot.data.realmmodel.RealmAlarm copyOrUpdate(Realm realm, com.rocklobstre.parrot.data.realmmodel.RealmAlarm object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.rocklobstre.parrot.data.realmmodel.RealmAlarm) cachedRealmObject;
        } else {
            com.rocklobstre.parrot.data.realmmodel.RealmAlarm realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((RealmAlarmRealmProxyInterface) object).realmGet$alarmId();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.RealmAlarmRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.rocklobstre.parrot.data.realmmodel.RealmAlarm copy(Realm realm, com.rocklobstre.parrot.data.realmmodel.RealmAlarm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rocklobstre.parrot.data.realmmodel.RealmAlarm) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.rocklobstre.parrot.data.realmmodel.RealmAlarm realmObject = realm.createObjectInternal(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class, ((RealmAlarmRealmProxyInterface) newObject).realmGet$alarmId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((RealmAlarmRealmProxyInterface) realmObject).realmSet$alarmTitle(((RealmAlarmRealmProxyInterface) newObject).realmGet$alarmTitle());
            ((RealmAlarmRealmProxyInterface) realmObject).realmSet$active(((RealmAlarmRealmProxyInterface) newObject).realmGet$active());
            ((RealmAlarmRealmProxyInterface) realmObject).realmSet$vibrateOnly(((RealmAlarmRealmProxyInterface) newObject).realmGet$vibrateOnly());
            ((RealmAlarmRealmProxyInterface) realmObject).realmSet$renewAutomatically(((RealmAlarmRealmProxyInterface) newObject).realmGet$renewAutomatically());
            ((RealmAlarmRealmProxyInterface) realmObject).realmSet$hourOfDay(((RealmAlarmRealmProxyInterface) newObject).realmGet$hourOfDay());
            ((RealmAlarmRealmProxyInterface) realmObject).realmSet$minute(((RealmAlarmRealmProxyInterface) newObject).realmGet$minute());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.rocklobstre.parrot.data.realmmodel.RealmAlarm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RealmAlarmColumnInfo columnInfo = (RealmAlarmColumnInfo) realm.schema.getColumnInfo(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((RealmAlarmRealmProxyInterface) object).realmGet$alarmId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$alarmTitle = ((RealmAlarmRealmProxyInterface)object).realmGet$alarmTitle();
        if (realmGet$alarmTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.alarmTitleIndex, rowIndex, realmGet$alarmTitle, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$active(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.vibrateOnlyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$vibrateOnly(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.renewAutomaticallyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$renewAutomatically(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.hourOfDayIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$hourOfDay(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.minuteIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$minute(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RealmAlarmColumnInfo columnInfo = (RealmAlarmColumnInfo) realm.schema.getColumnInfo(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.rocklobstre.parrot.data.realmmodel.RealmAlarm object = null;
        while (objects.hasNext()) {
            object = (com.rocklobstre.parrot.data.realmmodel.RealmAlarm) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((RealmAlarmRealmProxyInterface) object).realmGet$alarmId();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$alarmTitle = ((RealmAlarmRealmProxyInterface)object).realmGet$alarmTitle();
                if (realmGet$alarmTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.alarmTitleIndex, rowIndex, realmGet$alarmTitle, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$active(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.vibrateOnlyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$vibrateOnly(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.renewAutomaticallyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$renewAutomatically(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.hourOfDayIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$hourOfDay(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.minuteIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$minute(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rocklobstre.parrot.data.realmmodel.RealmAlarm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RealmAlarmColumnInfo columnInfo = (RealmAlarmColumnInfo) realm.schema.getColumnInfo(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((RealmAlarmRealmProxyInterface) object).realmGet$alarmId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$alarmTitle = ((RealmAlarmRealmProxyInterface)object).realmGet$alarmTitle();
        if (realmGet$alarmTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.alarmTitleIndex, rowIndex, realmGet$alarmTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.alarmTitleIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$active(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.vibrateOnlyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$vibrateOnly(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.renewAutomaticallyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$renewAutomatically(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.hourOfDayIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$hourOfDay(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.minuteIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$minute(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RealmAlarmColumnInfo columnInfo = (RealmAlarmColumnInfo) realm.schema.getColumnInfo(com.rocklobstre.parrot.data.realmmodel.RealmAlarm.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.rocklobstre.parrot.data.realmmodel.RealmAlarm object = null;
        while (objects.hasNext()) {
            object = (com.rocklobstre.parrot.data.realmmodel.RealmAlarm) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((RealmAlarmRealmProxyInterface) object).realmGet$alarmId();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$alarmTitle = ((RealmAlarmRealmProxyInterface)object).realmGet$alarmTitle();
                if (realmGet$alarmTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.alarmTitleIndex, rowIndex, realmGet$alarmTitle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.alarmTitleIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$active(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.vibrateOnlyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$vibrateOnly(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.renewAutomaticallyIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$renewAutomatically(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.hourOfDayIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$hourOfDay(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.minuteIndex, rowIndex, ((RealmAlarmRealmProxyInterface)object).realmGet$minute(), false);
            }
        }
    }

    public static com.rocklobstre.parrot.data.realmmodel.RealmAlarm createDetachedCopy(com.rocklobstre.parrot.data.realmmodel.RealmAlarm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rocklobstre.parrot.data.realmmodel.RealmAlarm unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rocklobstre.parrot.data.realmmodel.RealmAlarm)cachedObject.object;
            } else {
                unmanagedObject = (com.rocklobstre.parrot.data.realmmodel.RealmAlarm)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.rocklobstre.parrot.data.realmmodel.RealmAlarm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$alarmId(((RealmAlarmRealmProxyInterface) realmObject).realmGet$alarmId());
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$alarmTitle(((RealmAlarmRealmProxyInterface) realmObject).realmGet$alarmTitle());
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$active(((RealmAlarmRealmProxyInterface) realmObject).realmGet$active());
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$vibrateOnly(((RealmAlarmRealmProxyInterface) realmObject).realmGet$vibrateOnly());
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$renewAutomatically(((RealmAlarmRealmProxyInterface) realmObject).realmGet$renewAutomatically());
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$hourOfDay(((RealmAlarmRealmProxyInterface) realmObject).realmGet$hourOfDay());
        ((RealmAlarmRealmProxyInterface) unmanagedObject).realmSet$minute(((RealmAlarmRealmProxyInterface) realmObject).realmGet$minute());
        return unmanagedObject;
    }

    static com.rocklobstre.parrot.data.realmmodel.RealmAlarm update(Realm realm, com.rocklobstre.parrot.data.realmmodel.RealmAlarm realmObject, com.rocklobstre.parrot.data.realmmodel.RealmAlarm newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((RealmAlarmRealmProxyInterface) realmObject).realmSet$alarmTitle(((RealmAlarmRealmProxyInterface) newObject).realmGet$alarmTitle());
        ((RealmAlarmRealmProxyInterface) realmObject).realmSet$active(((RealmAlarmRealmProxyInterface) newObject).realmGet$active());
        ((RealmAlarmRealmProxyInterface) realmObject).realmSet$vibrateOnly(((RealmAlarmRealmProxyInterface) newObject).realmGet$vibrateOnly());
        ((RealmAlarmRealmProxyInterface) realmObject).realmSet$renewAutomatically(((RealmAlarmRealmProxyInterface) newObject).realmGet$renewAutomatically());
        ((RealmAlarmRealmProxyInterface) realmObject).realmSet$hourOfDay(((RealmAlarmRealmProxyInterface) newObject).realmGet$hourOfDay());
        ((RealmAlarmRealmProxyInterface) realmObject).realmSet$minute(((RealmAlarmRealmProxyInterface) newObject).realmGet$minute());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmAlarm = [");
        stringBuilder.append("{alarmId:");
        stringBuilder.append(realmGet$alarmId() != null ? realmGet$alarmId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{alarmTitle:");
        stringBuilder.append(realmGet$alarmTitle() != null ? realmGet$alarmTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{active:");
        stringBuilder.append(realmGet$active());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vibrateOnly:");
        stringBuilder.append(realmGet$vibrateOnly());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{renewAutomatically:");
        stringBuilder.append(realmGet$renewAutomatically());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hourOfDay:");
        stringBuilder.append(realmGet$hourOfDay());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{minute:");
        stringBuilder.append(realmGet$minute());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealmAlarmRealmProxy aRealmAlarm = (RealmAlarmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmAlarm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmAlarm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmAlarm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
