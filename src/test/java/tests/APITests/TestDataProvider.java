package tests.APITests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider()
    public static Object[][] getLeftSideBarCategoriesTestData() {
        return new Object[][]{
                {"2416", "Ноутбуки та комп’ютери", "https://rozetka.com.ua/ua/computers-notebooks/c80253/"},
                {"3361", "Смартфони, ТВ і електроніка", "https://rozetka.com.ua/ua/telefony-tv-i-ehlektronika/c4627949/"},
                {"4306", "Побутова техніка", "https://bt.rozetka.com.ua/ua/"},
                {"5300", "Товари для дому", "https://rozetka.com.ua/ua/tovary-dlya-doma/c2394287/"},
                {"6700", "Інструменти та автотовари", "https://rozetka.com.ua/ua/instrumenty-i-avtotovary/c4627858/"},
                {"7806", "Сантехніка та ремонт", "https://rozetka.com.ua/ua/santekhnika-i-remont/c4628418/"},
                {"8261", "Дача, сад і город", "https://rozetka.com.ua/ua/dacha-sad-ogorod/c2394297/"},
                {"9017", "Спорт і захоплення", "https://rozetka.com.ua/ua/sport-i-uvlecheniya/c4627893/"},
                {"10515", "Одяг, взуття та прикраси", "https://rozetka.com.ua/ua/shoes_clothes/c1162030/"},
                {"12258", "Краса та здоров’я", "https://rozetka.com.ua/ua/krasota-i-zdorovje/c4629305/"},
                {"13224", "Дитячі товари", "https://rozetka.com.ua/ua/kids/c88468/"},
                {"14127", "Офіс, школа, книги", "https://rozetka.com.ua/ua/office-school-books/c4625734/"},
                {"14939", "Алкогольні напої та продукти", "https://rozetka.com.ua/ua/alkoholnie-napitki-i-produkty/c4626923/"},
                {"15422", "Товари для бізнесу та послуги", "https://rozetka.com.ua/ua/tovary-dlya-biznesa/c4627851/"},
                {"15954", "Зоотовари", "https://rozetka.com.ua/ua/zootovary/c3520929/"},
                {"17191", "Сміливим вчитись до -45%", "https://rozetka.com.ua/ua/promo/schoolsoon/"},
                {"18421", "Товари для геймерів", "https://rozetka.com.ua/ua/game-zone/c80261/"}
        };
    }
}
