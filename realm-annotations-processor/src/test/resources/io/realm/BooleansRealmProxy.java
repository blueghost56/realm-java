package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import some.test.Booleans;

public class BooleansRealmProxy extends Booleans
        implements RealmObjectProxy {

    static final class BooleansColumnInfo extends ColumnInfo {

        public final long doneIndex;
        public final long isReadyIndex;
        public final long mCompletedIndex;
        public final long anotherBooleanIndex;

        BooleansColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.doneIndex = getValidColumnIndex(path, table, "Booleans", "done");
            indicesMap.put("done", this.doneIndex);

            this.isReadyIndex = getValidColumnIndex(path, table, "Booleans", "isReady");
            indicesMap.put("isReady", this.isReadyIndex);

            this.mCompletedIndex = getValidColumnIndex(path, table, "Booleans", "mCompleted");
            indicesMap.put("mCompleted", this.mCompletedIndex);

            this.anotherBooleanIndex = getValidColumnIndex(path, table, "Booleans", "anotherBoolean");
            indicesMap.put("anotherBoolean", this.anotherBooleanIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final BooleansColumnInfo columnInfo;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("done");
        fieldNames.add("isReady");
        fieldNames.add("mCompleted");
        fieldNames.add("anotherBoolean");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BooleansRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (BooleansColumnInfo) columnInfo;
    }

    @Override
    @SuppressWarnings("cast")
    public boolean isDone() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(columnInfo.doneIndex);
    }

    @Override
    public void setDone(boolean value) {
        realm.checkIfValid();
        row.setBoolean(columnInfo.doneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean isReady() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(columnInfo.isReadyIndex);
    }

    @Override
    public void setReady(boolean value) {
        realm.checkIfValid();
        row.setBoolean(columnInfo.isReadyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean ismCompleted() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(columnInfo.mCompletedIndex);
    }

    @Override
    public void setmCompleted(boolean value) {
        realm.checkIfValid();
        row.setBoolean(columnInfo.mCompletedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean getAnotherBoolean() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(columnInfo.anotherBooleanIndex);
    }

    @Override
    public void setAnotherBoolean(boolean value) {
        realm.checkIfValid();
        row.setBoolean(columnInfo.anotherBooleanIndex, value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Booleans")) {
            Table table = transaction.getTable("class_Booleans");
            table.addColumn(ColumnType.BOOLEAN, "done", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.BOOLEAN, "isReady", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.BOOLEAN, "mCompleted", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.BOOLEAN, "anotherBoolean", Table.NOT_NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Booleans");
    }

    public static BooleansColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Booleans")) {
            Table table = transaction.getTable("class_Booleans");
            if (table.getColumnCount() != 4) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 4 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final BooleansColumnInfo columnInfo = new BooleansColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("done")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'done' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("done") != ColumnType.BOOLEAN) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'boolean' for field 'done' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.doneIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'done' does support null values in the existing Realm file. Use corresponding boxed type for field 'done' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (!columnTypes.containsKey("isReady")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'isReady' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isReady") != ColumnType.BOOLEAN) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'boolean' for field 'isReady' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isReadyIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'isReady' does support null values in the existing Realm file. Use corresponding boxed type for field 'isReady' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (!columnTypes.containsKey("mCompleted")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'mCompleted' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("mCompleted") != ColumnType.BOOLEAN) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'boolean' for field 'mCompleted' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.mCompletedIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'mCompleted' does support null values in the existing Realm file. Use corresponding boxed type for field 'mCompleted' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (!columnTypes.containsKey("anotherBoolean")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'anotherBoolean' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("anotherBoolean") != ColumnType.BOOLEAN) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'boolean' for field 'anotherBoolean' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.anotherBooleanIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'anotherBoolean' does support null values in the existing Realm file. Use corresponding boxed type for field 'anotherBoolean' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Booleans class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Booleans";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static Booleans createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
            throws JSONException {
        Booleans obj = realm.createObject(Booleans.class);
        if (json.has("done")) {
            if (json.isNull("done")) {
                throw new IllegalArgumentException("Trying to set non-nullable field done to null.");
            } else {
                obj.setDone((boolean) json.getBoolean("done"));
            }
        }
        if (json.has("isReady")) {
            if (json.isNull("isReady")) {
                throw new IllegalArgumentException("Trying to set non-nullable field isReady to null.");
            } else {
                obj.setReady((boolean) json.getBoolean("isReady"));
            }
        }
        if (json.has("mCompleted")) {
            if (json.isNull("mCompleted")) {
                throw new IllegalArgumentException("Trying to set non-nullable field mCompleted to null.");
            } else {
                obj.setmCompleted((boolean) json.getBoolean("mCompleted"));
            }
        }
        if (json.has("anotherBoolean")) {
            if (json.isNull("anotherBoolean")) {
                throw new IllegalArgumentException("Trying to set non-nullable field anotherBoolean to null.");
            } else {
                obj.setAnotherBoolean((boolean) json.getBoolean("anotherBoolean"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static Booleans createUsingJsonStream(Realm realm, JsonReader reader)
            throws IOException {
        Booleans obj = realm.createObject(Booleans.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("done")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field done to null.");
                } else {
                    obj.setDone((boolean) reader.nextBoolean());
                }
            } else if (name.equals("isReady")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field isReady to null.");
                } else {
                    obj.setReady((boolean) reader.nextBoolean());
                }
            } else if (name.equals("mCompleted")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field mCompleted to null.");
                } else {
                    obj.setmCompleted((boolean) reader.nextBoolean());
                }
            } else if (name.equals("anotherBoolean")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field anotherBoolean to null.");
                } else {
                    obj.setAnotherBoolean((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Booleans copyOrUpdate(Realm realm, Booleans object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Booleans copy(Realm realm, Booleans newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Booleans realmObject = realm.createObject(Booleans.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setDone(newObject.isDone());
        realmObject.setReady(newObject.isReady());
        realmObject.setmCompleted(newObject.ismCompleted());
        realmObject.setAnotherBoolean(newObject.getAnotherBoolean());
        return realmObject;
    }

    static Booleans update(Realm realm, Booleans realmObject, Booleans newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setDone(newObject.isDone());
        realmObject.setReady(newObject.isReady());
        realmObject.setmCompleted(newObject.ismCompleted());
        realmObject.setAnotherBoolean(newObject.getAnotherBoolean());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Booleans = [");
        stringBuilder.append("{done:");
        stringBuilder.append(isDone());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isReady:");
        stringBuilder.append(isReady());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mCompleted:");
        stringBuilder.append(ismCompleted());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{anotherBoolean:");
        stringBuilder.append(getAnotherBoolean());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

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
        BooleansRealmProxy aBooleans = (BooleansRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aBooleans.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aBooleans.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aBooleans.row.getIndex()) return false;

        return true;
    }

}
