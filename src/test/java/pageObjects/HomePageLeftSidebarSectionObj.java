package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.SneakyThrows;
import textsOnPages.EN_HomePageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class HomePageLeftSidebarSectionObj {

    private final SelenideElement header_Category = $(".left-sidebar > h2");

    private final ElementsCollection allMainCategories = $$("#accordian.category-products div h4 a"); // used for left side subcategory search
    private final SelenideElement btn_CategoryWomen = allMainCategories.get(0); // Categories -> Women, Man, Kids
    private final ElementsCollection allWomanSubcategories = $$("div#Women li a"); // Women -> all Subcategories collection
    private final SelenideElement btn_WomanSubcategory_Dress = allWomanSubcategories.get(0); // Women -> Dress
    private final SelenideElement btn_WomanSubcategory_Tops = allWomanSubcategories.get(1); // Women -> Tops
    private final SelenideElement btn_WomanSubcategory_Saree = allWomanSubcategories.get(2); // Women -> Saree
    private final SelenideElement btn_CategoryMen = allMainCategories.get(1);
    private final ElementsCollection allMenSubcategories = $$("div#Men li a");
    private final SelenideElement btn_MenSubcategory_Tshirts = allMenSubcategories.get(0);
    private final SelenideElement btn_MenSubcategory_Jeans = allMenSubcategories.get(1);
    private final SelenideElement btn_CategoryKids = allMainCategories.get(2);
    private final ElementsCollection allKidsSubcategories = $$("div#Kids li a");
    private final SelenideElement btn_KidsSubcategory_Dress = allKidsSubcategories.get(0);
    private final SelenideElement btn_KidsSubcategory_TopsAndShirts = allKidsSubcategories.get(1);

    private final SelenideElement header_Brands = $(".brands_products > h2");
    private final ElementsCollection allBrands = $$(".brands-name li");
    private final SelenideElement btn_BrandsPolo = allBrands.get(0);
    private final SelenideElement btn_BrandsMandM = allBrands.get(1);
    private final SelenideElement btn_BrandsMadame = allBrands.get(2);
    private final SelenideElement btn_BrandsMastAndHarbour = allBrands.get(3);
    private final SelenideElement btn_BrandsBabyhug = allBrands.get(4);
    private final SelenideElement btn_BrandsAllenSollyJunior = allBrands.get(5);
    private final SelenideElement btn_BrandsKookieKids = allBrands.get(6);
    private final SelenideElement btn_BrandsBiba = allBrands.get(7);

    public void clickOnWomenCategory() {
        btn_CategoryWomen.click();
    }

    public void clickOnMenCategory() {
        btn_CategoryMen.click();
    }

    public void clickOnKidsCategory() {
        btn_CategoryKids.click();
    }

    @SneakyThrows
    public void verifyLeftSidebarCategory() {
        header_Category.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.HEADER_CATEGORY));
        btn_CategoryWomen.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_WOMAN));
        clickOnWomenCategory();
        btn_WomanSubcategory_Dress.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_WOMAN_DRESS));
        btn_WomanSubcategory_Tops.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_WOMAN_TOPS));
        btn_WomanSubcategory_Saree.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_WOMAN_SAREE));

        btn_CategoryMen.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_MEN));
        clickOnMenCategory();
        btn_MenSubcategory_Tshirts.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_MEN_TSHIRTS));
        btn_MenSubcategory_Jeans.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_MEN_JEANS));

        clickOnKidsCategory();
        btn_CategoryKids.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_KIDS));
        btn_KidsSubcategory_Dress.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_KIDS_DRESS));
        btn_KidsSubcategory_TopsAndShirts.shouldBe(visible).shouldHave(exactText(EN_HomePageTexts.CATEGORY_KIDS_TOPS_SHIRTS));
    }

    public void verifyLeftSidebarBrands() {
        // Check brands
        header_Brands.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_BRANDS));
        btn_BrandsPolo.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_POLO));
        btn_BrandsMandM.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_H_M));
        btn_BrandsMadame.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_MADAME));
        btn_BrandsMastAndHarbour.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_MAST_HARBOUR));
        btn_BrandsBabyhug.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_POLO_BABYHUG));
        btn_BrandsAllenSollyJunior.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_POLO_ALLEN_SOLLY_JUNIOR));
        btn_BrandsKookieKids.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_POLO_KOOKIE_KIDS));
        btn_BrandsBiba.shouldBe(visible).shouldHave(text(EN_HomePageTexts.BRANDS_NAME_POLO_BIBA));
    }
}
