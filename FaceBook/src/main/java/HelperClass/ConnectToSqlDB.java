package HelperClass;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectToSqlDB{

        public static Connection connect = null;
        public static Statement statement = null;
        public static PreparedStatement ps = null;
        public static ResultSet resultSet = null;
        public static ResultSet resultSet2 = null;

        public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
            String url = "jdbc:mysql://localhost:3306/pnt?useSSL=false&allowPublicKeyRetrieval=true";
            String userName = "root";
            String password = "bu8314";
            connect = DriverManager.getConnection(url,userName,password);
            System.out.println("Database is connected");
            return connect;
        }
        public void createTableFromStringToMySql(String tableName, String columnName) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
                ps.executeUpdate();
                ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` varchar(2500) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
                ps.executeUpdate();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void createTableFromStringToMySql2(String tableName, String columnName1,String columnName2) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
                ps.executeUpdate();
                ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`"+columnName1+"` varchar(2500) DEFAULT NULL,`"+columnName2+"` varchar(2500) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
                ps.executeUpdate();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public List<String> readDataBase(String tableName, String columnName)throws Exception{
            List<String> data = new ArrayList<String>();
            try {
                connectToSqlDatabase();
                statement = connect.createStatement();
                resultSet = statement.executeQuery("select * from " + tableName);
                data = getResultSetData(resultSet, columnName);
            } catch (ClassNotFoundException e) {
                throw e;
            }finally{
                close();
            }
            return data;
        }
        public List<String> readDataBase1(String tableName, String columnName1, String columnName2)throws Exception{
            List<String> data = new ArrayList<String>();
            try {
                connectToSqlDatabase();
                statement = connect.createStatement();
                resultSet = statement.executeQuery("select * from " + tableName);
                data = getResultSetData1(resultSet, columnName1, columnName2);
            } catch (ClassNotFoundException e) {
                throw e;
            }finally{
                close();
            }
            return data;
        }
        private void close() {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connect != null){
                    connect.close();
                }
            }catch(Exception e){
            }
        }
        private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
            List<String> dataList = new ArrayList<String>();
            while(resultSet.next()){
                String itemName = resultSet.getString(columnName);
                dataList.add(itemName);
            }
            return dataList;
        }
        private List<String> getResultSetData1(ResultSet resultSet2, String columnName1, String columnName2) throws SQLException {
            List<String> dataList = new ArrayList<String>();
            while(resultSet.next()){
                String itemName1 = resultSet.getString(columnName1);
                String itemName2 = resultSet.getString(columnName2);
                dataList.add(itemName1);
                dataList.add(itemName2);
            }
            return dataList;
        }
        public void insertDataFromArrayToSqlTable(int [] ArrayData, String tableName, String columnName) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
                ps.executeUpdate();
                ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
                ps.executeUpdate();
                for(int n=0; n<ArrayData.length; n++){
                    ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                    ps.setInt(1,ArrayData[n]);
                    ps.executeUpdate();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                ps.setString(1,ArrayData);
                ps.executeUpdate();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public List<String> directDatabaseQueryExecute(String passQuery,String dataColumn)throws Exception{
            List<String> data = new ArrayList<String>();

            try {
                connectToSqlDatabase();
                statement = connect.createStatement();
                resultSet = statement.executeQuery(passQuery);
                data = getResultSetData(resultSet, dataColumn);
            } catch (ClassNotFoundException e) {
                throw e;
            }finally{
                close();
            }
            return data;
        }
        public void InsertDataFromArrayListToMySql2(List<String> list,String tableName, String columnName1,String columnName2 ) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                String key = list.get(0);
                String value = list.get(1);
                System.out.println("key is:"+ key + " value is:" + value);

                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
                ps.setString(1,key);
                ps.setString(2,value);
                ps.executeUpdate();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void createTableFromStringToMySql2col(String tableName, String columnName1,String columnName2) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
                ps.executeUpdate();
                ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`"+columnName1+"` varchar(2500) DEFAULT NULL,`"+columnName2+"` varchar(2500) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
                ps.executeUpdate();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void insertDataFromArrayListToSqlTable(List<String> list, String tableName, String columnName) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("DROP TABLE IF EXISTS `" +tableName+"`;");
                ps.executeUpdate();
                ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`"+ columnName+"` varchar(2500) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
                ps.executeUpdate();
                for(String ob :list){
                    ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                    ps.setObject(1,ob);
                    ps.executeUpdate();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2) throws InstantiationException, IllegalAccessException {
            try {
                connectToSqlDatabase();
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
                ps.setString(1,"Ankita Sing");
                ps.setInt(2,3590);
                ps.executeUpdate();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }













