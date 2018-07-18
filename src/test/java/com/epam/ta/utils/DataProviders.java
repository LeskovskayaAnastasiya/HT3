package com.epam.ta.utils;

public class DataProviders {

    public DataProviders() {
    }

    @org.testng.annotations.DataProvider(
            name = "DataProviderForLogin"
    )
    public static Object[][] incorrectDataForLogin() {
        return new Object[][]{
                // подаставляем граничное (дробное) значение сторонам
                {"anastasialeskovskaya1991","130588"},//incorrect password
                {"anastasialeskovskaya1","130588mc"},//incorrect name
                {"аnаstasialeskovskaya1991","130588mс"}//incorrect name  (The symbol "a"  is russian) and password (The symbol "c"  is russian)
        };
    }

    @org.testng.annotations.DataProvider(
            name = "DataProviderForCreateRepo"
    )
    public static Object[][] dataProvider() {
        return new Object[][]{
                // подаставляем граничное (дробное) значение сторонам
                {"checkNewRepositoryLink"},
                {"checkNewRepositoryButton"},
                {"checkStartProjectButton"}
        };
    }
}




