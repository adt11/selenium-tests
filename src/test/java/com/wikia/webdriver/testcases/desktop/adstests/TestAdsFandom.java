package com.wikia.webdriver.testcases.desktop.adstests;

import com.wikia.webdriver.common.contentpatterns.AdSlot;
import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.annotations.InBrowser;
import com.wikia.webdriver.common.core.drivers.Browser;
import com.wikia.webdriver.common.core.helpers.Emulator;
import com.wikia.webdriver.common.dataprovider.ads.FandomAdsDataProvider;
import com.wikia.webdriver.common.templates.fandom.AdsFandomTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsFandomObject;

import org.testng.annotations.Test;

public class TestAdsFandom extends AdsFandomTestTemplate {

  @Test(groups = {"AdsDesktopPresenceFandom", "AdsDesktopFandom"})
  public void adsFandomAdsArticleDesktop() {
    AdsFandomObject fandomPage = loadArticle(FandomAdsDataProvider.PAGE_NON_UAP_ARTICLE);
    verifySlots(fandomPage);
  }

  @Test(groups = {"AdsDesktopPresenceFandom", "AdsDesktopFandom"})
  public void adsFandomAdsTopicDesktop() {
    AdsFandomObject fandomPage = loadTopic(FandomAdsDataProvider.PAGE_NON_UAP_TOPIC);
    verifySlots(fandomPage);
  }

  @InBrowser(browser = Browser.CHROME, emulator = Emulator.GOOGLE_NEXUS_5)
  @Test(groups = {"AdsMobilePresenceFandom", "AdsMobileFandom"})
  public void adsFandomAdsArticleMobile() {
    AdsFandomObject fandomPage = loadArticle(FandomAdsDataProvider.PAGE_NON_UAP_ARTICLE);
    verifySlots(fandomPage);
  }

  @InBrowser(browser = Browser.CHROME, emulator = Emulator.GOOGLE_NEXUS_5)
  @Test(groups = {"AdsMobilePresenceFandom", "AdsMobileFandom"})
  public void adsFandomAdsTopicMobile() {
    AdsFandomObject fandomPage = loadTopic(FandomAdsDataProvider.PAGE_NON_UAP_TOPIC);
    verifySlots(fandomPage);
  }

  @Test(groups = {"AdsDesktopPresenceFandom", "AdsDesktopFandom"})
  public void adsFandomAdsArticleUAPDesktop() {
    AdsFandomObject fandomPage = loadArticle(FandomAdsDataProvider.PAGE_HIVI_UAP_ARTICLE);
    verifyUAPSlots(fandomPage);
  }

  @InBrowser(browser = Browser.CHROME, emulator = Emulator.GOOGLE_NEXUS_5)
  @Test(groups = {"AdsMobilePresenceFandom", "AdsMobileFandom"})
  public void adsFandomAdsArticleUAPMobile() {
    AdsFandomObject fandomPage = loadArticle(FandomAdsDataProvider.PAGE_HIVI_UAP_ARTICLE);
    verifyUAPSlotsMobile(fandomPage);
  }

  private void verifySlots(AdsFandomObject fandomPage) {
    fandomPage.triggerOnScrollSlots();
    fandomPage.verifySlot(AdSlot.TOP_LEADERBOARD);
    fandomPage.verifySlot(AdSlot.TOP_BOXAD);
    Assertion.assertNull(fandomPage.getSlot(AdSlot.FEED_BOXAD));
    Assertion.assertNull(fandomPage.getSlot(AdSlot.BOTTOM_BOXAD));
    Assertion.assertNull(fandomPage.getSlot(AdSlot.INCONTENT_BOXAD));
    Assertion.assertNull(fandomPage.getSlot(AdSlot.BOTTOM_LEADERBOARD));
  }

  private void verifyUAPSlots(AdsFandomObject fandomPage) {
    fandomPage.triggerOnScrollSlots();
    fandomPage.verifySlot(AdSlot.TOP_LEADERBOARD);
    fandomPage.verifySlot(AdSlot.TOP_BOXAD);
    fandomPage.verifySlot(AdSlot.FEED_BOXAD);
    fandomPage.verifySlot(AdSlot.BOTTOM_LEADERBOARD);
    Assertion.assertNull(fandomPage.getSlot(AdSlot.BOTTOM_BOXAD));
    Assertion.assertNull(fandomPage.getSlot(AdSlot.INCONTENT_BOXAD));
  }

  private void verifyUAPSlotsMobile(AdsFandomObject fandomPage) {
    fandomPage.triggerOnScrollSlots();
    fandomPage.verifySlot(AdSlot.TOP_LEADERBOARD);
    fandomPage.verifySlot(AdSlot.TOP_BOXAD);
    fandomPage.verifySlot(AdSlot.FEED_BOXAD_MOBILE);
    fandomPage.verifySlot(AdSlot.BOTTOM_LEADERBOARD);
    Assertion.assertNull(fandomPage.getSlot(AdSlot.BOTTOM_BOXAD));
    Assertion.assertNull(fandomPage.getSlot(AdSlot.INCONTENT_BOXAD));
  }
}
