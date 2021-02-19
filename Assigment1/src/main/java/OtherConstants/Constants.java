package OtherConstants;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public  class Constants {

    public static class CurrentEmployee {
        private static long currentEmployee=0;

        public static long getCurrentEmployee() {
            return currentEmployee;
        }

        public static void setCurrentEmployee(long currentEmployee) {
            CurrentEmployee.currentEmployee = currentEmployee;
        }
    }


}
