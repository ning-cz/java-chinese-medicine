public class DAOFactory {
    public static IMedicineDAO getMedicineDAO() {
        return new MedicineDAO();
    }

    public static IPrescriptionDAO getPrescriptionDAO() {
        return new PrescriptionDAO();
    }

    @SuppressWarnings("unchecked")
    public static <T> GenericDAO<T> getGenericDAO(Class<T> type) {
        if (type == Medicine.class) {
            return (GenericDAO<T>) new MedicineDAO();
        } else if (type == Prescription.class) {
            return (GenericDAO<T>) new PrescriptionDAO();
        }
        throw new IllegalArgumentException("不支持的实体类型: " + type.getName());
    }
}