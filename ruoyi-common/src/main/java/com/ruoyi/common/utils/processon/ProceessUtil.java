package com.ruoyi.common.utils.processon;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.ruoyi.common.utils.processon.model.Children;
import com.ruoyi.common.utils.processon.model.JsonRootBean;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProceessUtil {

    public static void parse(String json){
        JSONObject jsonObject = new JSONObject(json);
        JsonRootBean jsonRootBean = jsonObject.toBean(JsonRootBean.class);
        List<Children> childrens = jsonRootBean.getDiagram().getElements().getChildren().get(1).getChildren();
        for(Children children : childrens){
            if(children.getTitle().equals("无请求量且现客户端无调用")){
                continue;
            }
            String note = children.getNote();
            if(StringUtils.hasText(note)){
                String[] split = note.split("\n");
                for(String s : split){
                    Children c = new Children();
                    c.setId(genId());
                    c.setParent(children.getId());
                    c.setTitle(s);
                    c.setChildren(Lists.newArrayList());
                    children.getChildren().add(c);
                }
            }
        }

        childrens = jsonRootBean.getDiagram().getElements().getChildren().get(2).getChildren();
        for(Children children : childrens){
            if(children.getTitle().equals("无请求量且客户端无调用")){
                continue;
            }
            String note = children.getNote();
            if(StringUtils.hasText(note)){
                String[] split = note.split("\n");
                for(String s : split){
                    Children c = new Children();
                    c.setId(genId());
                    c.setParent(children.getId());
                    c.setTitle(s);
                    c.setChildren(Lists.newArrayList());
                    children.getChildren().add(c);
                }
            }
        }

        childrens = jsonRootBean.getDiagram().getElements().getChildren().get(3).getChildren();
        for(Children children : childrens){

            String note = children.getNote();
            if(StringUtils.hasText(note)){
                String[] split = note.split("\n");
                for(String s : split){
                    Children c = new Children();
                    c.setId(genId());
                    c.setParent(children.getId());
                    c.setTitle(s);
                    c.setChildren(Lists.newArrayList());
                    children.getChildren().add(c);
                }
            }
        }

        String s = JSONUtil.toJsonStr(jsonRootBean);
        System.out.println(s);
    }

    public static void main(String[] args) {
        String json = "{\"diagram\":{\"image\":{\"height\":200,\"pngdata\":\"iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAYAAACtWK6eAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAsUlEQVR4nO3BAQEAAACCIP+vbkhAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB8GXHmAAFMgHIEAAAAAElFTkSuQmCC\",\"width\":200,\"y\":0,\"x\":0},\"elements\":{\"id\":\"root\",\"structure\":\"mind_free\",\"leftChildren\":[],\"title\":\"redfinger-gn\",\"watermark\":\"\",\"root\":true,\"theme\":\"gsx_notes_white\",\"summaries\":[],\"children\":[{\"id\":\"f00d34a32db9\",\"title\":\"biz-server\",\"lineStyle\":{\"randomLineColor\":\"#127c97\"},\"children\":[{\"id\":\"f1198c50a820\",\"title\":\"topic:biz-channel\",\"parent\":\"f00d34a32db9\",\"children\":[{\"id\":\"22b62c0e23ad\",\"title\":\"小程序授权\",\"parent\":\"f1198c50a820\",\"children\":[],\"note\":\"小程序推广  \\n调用https://api-xcx.7me.com/cp/values/authority\"}]},{\"id\":\"df01a2c0d55b\",\"title\":\"topic:finger-bizserver\",\"parent\":\"f00d34a32db9\",\"children\":[{\"id\":\"4d92f88c421c\",\"title\":\"osType:download\",\"children\":[],\"parent\":\"df01a2c0d55b\",\"note\":\"第三方用户首次登录 下载保存用户头像\"},{\"id\":\"71a42347ad3e\",\"title\":\"osType:addInviterByBindPhone<br>\",\"parent\":\"df01a2c0d55b\",\"children\":[],\"note\":\"使用手机号被邀请  \\n但第一次登陆时使用第三方登陆  \\n在绑定手机时判断发放奖励Mq\"},{\"id\":\"b5ad134ac0bd\",\"title\":\"osType:login\",\"parent\":\"df01a2c0d55b\",\"children\":[],\"note\":\"1.保存 sys_login_log 记录\\n2.发送活动奖励Mq(推广活动、购买赠送)\\n3.屏幕分享助力活动记录\"}]}],\"parent\":\"root\",\"collapsed\":false},{\"id\":\"9241c2897ae0\",\"title\":\"fingerauth<br>\",\"lineStyle\":{\"randomLineColor\":\"rgb(51, 156, 168)\"},\"parent\":\"root\",\"children\":[{\"id\":\"9af37c02191a\",\"title\":\"无请求量且现客户端无调用\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/activation/checkActivationCode.html\\n/fingerauth/config/getUrls.html\\n/fingerauth/activity/getActivityByActivityTagCode.html\\n/fingerauth/app/apkDetail.html\\n/fingerauth/app/apkCommentCommit.html\\n/fingerauth/app/apkCommentPage.html\\n/fingerauth/app/deptApkPage.html\\n/fingerauth/app/developer.html\\n/fingerauth/app/appFindList.html\\n/fingerauth/app/rankList.html\\n/fingerauth/app/rankApkPage.html\\n/fingerauth/app/recommendApkPage.html\\n/fingerauth/app/recommendList.html\\n/fingerauth/app/search.html\\n/fingerauth/app/searchTop.html\\n/fingerauth/app/interest.html\\n/fingerauth/app/feedback.html\\n/fingerauth/app/appIp.html\\n/fingerauth/app/autocomplete.html\\n/fingerauth/app/categoryList.html\\n/fingerauth/app/categoryApkPage.html\\n/fingerauth/app/apkCommentGood.html\\n/fingerauth/app/rfclassList.html\\n/fingerauth/broadCast/getBroadcastList.html\\n/fingerauth/broadCast/updateClickRate.html\\n/fingerauth/channel/findstatus.html\\n/fingerauth/channel/check.html\\n/fingerauth/command/screen.html\\n/fingerauth/command/reboot.html\\n/fingerauth/config/getWeixinConf.html\\n/fingerauth/time/now.html\\n/fingerauth/email/test.html\\n/fingerauth/email/checkVaildCode.html\\n/fingerauth/email/sendCloudVaildCode.html\\n/fingerauth/fault/saveFault.html\\n/fingerauth/fault/getFaultsByUserId.html\\n/fingerauth/geFault/getFaultList.html\\n/fingerauth/geFault/getFaultAnswer.html\\n/fingerauth/goods/getVipGoods.html\\n/fingerauth/goodsInfo/getGoodsTypeInfos.html\\n/fingerauth/grant/bindPadByGrantCode.html\\n/fingerauth/iap/receipt.html\\n/fingerauth/idc/getIdc.html\\n/fingerauth/getServerDate.html\\n/fingerauth/ad/getAdImage.html\\n/fingerauth/images/getFreePadBindImage.html\\n/fingerauth/images/getTastePadBindImage.html\\n/fingerauth/images/getGamePadBindImage.html\\n/fingerauth/label/getFaultLabels.html\\n/fingerauth/offlineNotice/check.html\\n/fingerauth/offlineNotice/close.html\\n/fingerauth/offlineNotice/open.html\\n/fingerauth/order/getOrders.html\\n/fingerauth/pad/getPadByToken.html\\n/fingerauth/pad/getPad.html\\n/fingerauth/share/getwxShare.html\\n/fingerauth/shop/limitedEditionPackageList.html\\n/fingerauth/shop/redfingerPackageList.html\\n/fingerauth/bindPadSms/checkValidata.html\\n/fingerauth/sms/sendByResetImg.html\\n/fingerauth/sms/sendByReset.html\\n/fingerauth/sms/sendBySignUp.html\\n/fingerauth/sms/sendByBindUserPhoneImg.html\\n/fingerauth/sms/sendByBindUserPhone.html\\n/fingerauth/sms/sendSmsMethod.html\\n/fingerauth/sms/sendUnBundEmailVaildCode.html\\n/fingerauth/stat/newUserClickEvents.html\\n/fingerauth/stat/clickEvents.html\\n/fingerauth/survey/obtain.html\\n/fingerauth/survey/submit.html\\n/fingerauth/newtask/gameSubmitCheck.html\\n/fingerauth/newtask/getTasks.html\\n/fingerauth/newtask/acessTasks.html\\n/fingerauth/newtask/receiveTasks.html\\n/fingerauth/newtask/getCheckGameAccount.html\\n/fingerauth/newtask/apkDComplete.html\\n/fingerauth/receive/invite.html\\n/fingerauth/task/attendance.html\\n/fingerauth/task/receiveTask.html\\n/fingerauth/task/receiveAward.html\\n/fingerauth/task/finishTask.html\\n/fingerauth/task/completionData.html\\n/fingerauth/tktask/getTaskModule.html\\n/fingerauth/task/getPcTasks.html\\n/fingerauth/task/invite.html\\n/fingerauth/task/receive.html\\n/fingerauth/task/acess.html\\n/fingerauth/task/getTasks.html\\n/fingerauth/user/getUser.html\\n/fingerauth/user/getDeviceToken.html\\n/fingerauth/user/getKey.html\\n/fingerauth/user/updateNickNameOrImage.html\\n/fingerauth/user/logout.html\\n/fingerauth/user/checkMobile.html\\n/fingerauth/user/modifyUserInfo.html\\n/fingerauth/user/signup.html\\n/fingerauth/user/bindPhone.html\\n/fingerauth/user/bindPad2.html\\n/fingerauth/user/bindTastePad.html\\n/fingerauth/user/checkPwd.html\\n/fingerauth/user/bindFreePadForPojie.html\\n/fingerauth/version/getNewVersion.html\\n/fingerauth/version/getLatest.html\"},{\"id\":\"80a0e0cefa16\",\"title\":\"激活码相关\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/activation/activationActivationCode.html\\n/fingerauth/activation/activationCodeRenewRs.html\\n/fingerauth/activation/batchActivationCodeRenewRs.html\\n/fingerauth/activation/batchActivationCodeRs.html\\n/fingerauth/activation/checkActivationCodeRs.html\\n/fingerauth/activation/needValidateCode.html\\n/fingerauth/activation/sendVoiceSms.html\"},{\"id\":\"ff152a44b628\",\"title\":\"授权设备相关\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/grant/bindPadByGrantCodeRs.html\\n/fingerauth/grant/cancelPadGrant.html\\n/fingerauth/grant/generateGrantCode.html\\n/fingerauth/grant/getPadGrantInfo.html\\n/fingerauth/grant/getPadList.html\\n/fingerauth/grant/grantPad2Account.html\\n/fingerauth/grant/needValidCode.html\"},{\"id\":\"9e4fe3e387ed\",\"title\":\"广告\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/ad/getAd.html\\n/fingerauth/ad/savePictureLog.html\"},{\"id\":\"b1c72677c0fc\",\"title\":\"活动信息\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/activity/getActivity.html\\n/fingerauth/activity/getWebLink.html\"},{\"id\":\"d77545f21188\",\"title\":\"应用及统计\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/app/apkLogDownload.html\\n/fingerauth/app/getApkVersionList.html\\n/fingerauth/app/updateAppDetails.html\\n/fingerauth/game/getGameAppList.html\"},{\"id\":\"7381f24fb937\",\"title\":\"消息、通知、资讯、提醒<br>\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/message/checkAllIsRead.html\\n/fingerauth/message/checkMessageIsRead.html\\n/fingerauth/message/getMessage.html\\n/fingerauth/message/getMessageList.html\\n/fingerauth/message/getMessageListRs.html\\n/fingerauth/message/updateMessageIsRead.html\\n/fingerauth/offlineNotice/checkBindPhone.html\\n/fingerauth/offlineNotice/checkOfflineRemind.html\\n/fingerauth/offlineNotice/getGameMonitorList.html\\n/fingerauth/offlineNotice/getOfflineRemindStatus.html\\n/fingerauth/offlineNotice/updatePadOfflineRemindStatus.html\\n/fingerauth/offlineNotice/updateUserOfflineRemindStatus.html\\n/fingerauth/userNotice/getUserNoticePage.html\\n/fingerauth/userNotice/getUserNoticePageRs.html\\n/fingerauth/information/getInformationList.html\\n/fingerauth/information/getNoReadInformation.html\\n/fingerauth/information/setUpInformation.html\\n/fingerauth/information/setUpInformationPC.html\\n/fingerauth/reminded/getRemindeds.html\\n/fingerauth/reminded/saveGiftReminded.html\\n/fingerauth/reminded/saveTaskReminded.html\"},{\"id\":\"eb979190ea95\",\"title\":\"百度续费合同\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/contractpad/activate.html\\n/fingerauth/contractpad/cancel.html\\n/fingerauth/contractpad/detail.html\\n/fingerauth/contractpad/userpadcontracts.html\"},{\"id\":\"0d747047d365\",\"title\":\"短信\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/sms/sendBySignUpImg.html\\n/fingerauth/sms/sendUnBundEmailVaildCodeRs.html\\n/fingerauth/bindPadSms/checkValidataRs.html\"},{\"id\":\"366b039dd4b5\",\"title\":\"邮箱\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/email/checkEmailValidCode.html\\n/fingerauth/email/checkVaildCodeRs.html\\n/fingerauth/email/needUserEmailCode.html\\n/fingerauth/email/sendUnBundEmailVaildCode.html\\n/fingerauth/email/unBundEmail.html\"},{\"id\":\"fd9c89dfda2f\",\"title\":\"图片\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/images/getActivationImage.html\\n/fingerauth/images/getGrantImage.html\\n/fingerauth/images/getUnBundEmailImage.html\\n/fingerauth/images/getUserEmailImage.html\\n/fingerauth/user/getImge.html\"},{\"id\":\"a712374b3a35\",\"title\":\"礼包\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/shop/buyPackageList.html\\n/fingerauth/shop/detailPackageList.html\\n/fingerauth/shop/discountPackageList.html\\n/fingerauth/shop/gamePackageList.html\\n/fingerauth/shop/myPackageList.html\\n/fingerauth/gift/myGiftList.html\"},{\"id\":\"56eaa0055eb7\",\"title\":\"任务相关\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/tktask/finishTask.html\\n/fingerauth/tktask/getSigninTask.html\\n/fingerauth/tktask/getSubTaskList.html\\n/fingerauth/tktask/getTaskList.html\\n/fingerauth/tktask/receiveAward.html\\n/fingerauth/tktask/receiveTask.html\"},{\"id\":\"fa6d35b30bee\",\"title\":\"用户信息\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/user/getUserData.html\\n/fingerauth/user/getUserGradeInfo.html\\n/fingerauth/user/getUserInfo.html\\n/fingerauth/user/getUserNextGradeInfo.html\\n/fingerauth/user/saveUserData.html\\n/fingerauth/user/updateNickName.html\\n/fingerauth/user/updateUserData.html\\n/fingerauth/user/getBankInfo.html\"},{\"id\":\"3944feaf5436\",\"title\":\"钱包\",\"parent\":\"9241c2897ae0\",\"children\":[],\"note\":\"/fingerauth/wallet/orderPay.html\\n/fingerauth/wallet/recharge.html\\n/fingerauth/wallet/recordList.html\"},{\"id\":\"dcb502200faf\",\"title\":\"视频分享\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/share/cancelToken.html\\n/fingerauth/share/getShare.html\\n/fingerauth/share/getShareNumber.html\\n/fingerauth/share/getToken.html\"},{\"id\":\"6bc9cd9e8225\",\"title\":\"SVIP退款\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/refund/svipRefund.html\\n/fingerauth/refund/svipRefundConfirm.html\\n/fingerauth/refund/svipRefundConfirmAutoRenew.html\\n/fingerauth/refund/svipRefundProcess.html\"},{\"id\":\"533c8905646d\",\"title\":\"套餐相关\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/goods/bf2/previewPurchase.html\\n/fingerauth/goods/bf2/previewRecharge.html\\n/fingerauth/goods/bf2/previewUpdateGvip.html\\n/fingerauth/goods/getVipGoodsNew.html\\n/fingerauth/goods/getVipGoodsNewPage.html\\n/fingerauth/goods/getWalletGoods.html\\n/fingerauth/goodsInfo/getGoodsTypeInfosNew.html\\n/fingerauth/order/toUpgradeGvip.html\"},{\"id\":\"fbc1ed8ead90\",\"title\":\"获取设备信息(修改)\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/pad/getControlCode.html\\n/fingerauth/pad/getExpirePadList.html\\n/fingerauth/pad/getPadInfoByUserPadId.html\\n/fingerauth/pad/getPadRbcStandard.html\\n/fingerauth/pad/getPhoneInfo.html\\n/fingerauth/pad/padMountStatus.html\\n/fingerauth/pad/renewPadInfo.html\\n/fingerauth/pad/shareSuccess.html\\n/fingerauth/pad/updatePadInfo.html\\n/fingerauth/pad/upPadName.html\"},{\"id\":\"bb3ee0129c58\",\"title\":\"红豆兑换相关\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/pad/exChangeRbc.html\\n/fingerauth/rbcRecord/getRbcRecord.html\"},{\"id\":\"b89f8caef247\",\"title\":\"优惠券\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/coupon/bf2/getCouponList.html\\n/fingerauth/coupon/getCouponList.html\"},{\"id\":\"a450a5fe8956\",\"title\":\"校验购买支持\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/user/checkGamePad.html\\n/fingerauth/user/checkGvipPad.html\\n/fingerauth/user/checkPad.html\\n/fingerauth/user/checkPadProbation.html\\n/fingerauth/user/checkVipPad.html\\n/fingerauth/goods/bf2/iosSupport.html\"},{\"id\":\"0cf7c9305ecf\",\"title\":\"任务相关\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/tktask/getSubTaskList.html\\n/fingerauth/tktask/receiveAward.html\\n/fingerauth/tktask/receiveTask.html\"},{\"id\":\"315b1d0e150b\",\"title\":\"获取资源、配置\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/mobileModel/list.html\\n/fingerauth/user/getArea.html\\n/fingerauth/tip/getOpenMultipleCustomerService.html\\n/fingerauth/channel/discover.html\\n/fingerauth/moduleIcon/getAppModuleIconList.html\\n/fingerauth/order/getPayModes.html\\n/fingerauth/order/getPayModesV2.html\\n/fingerauth/config/getConfig.html\\n/fingerauth/config/getRedPtionConfig.html\\n/fingerauth/config/getShowIcon.html\"},{\"id\":\"718539b94000\",\"title\":\"订单信息\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/order/bf2/getOrders.html\\n\\n/fingerauth/order/getOrderDetail.html\\n/fingerauth/order/getOrderStatus.html\\n\"},{\"id\":\"811c526f3dd0\",\"title\":\"下单\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/order/buy.html\\n/fingerauth/order/computeOrderPrice.html\\n/fingerauth/order/pricecalculator.html\\n/fingerauth/order/recharge.html\\n/fingerauth/order/upgradeGvipBuy.html\\n/fingerauth/wallet/orderPay.html\"},{\"id\":\"4a4a7e24f0ea\",\"title\":\"主动绑定\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/user/bindPad.html\"},{\"id\":\"c681ce97e1c1\",\"title\":\"版本校验\",\"children\":[],\"parent\":\"9241c2897ae0\",\"note\":\"/fingerauth/version/checkNewVersion.html\"}],\"collapsed\":false},{\"id\":\"c54124d4494e\",\"title\":\"fingerlogin\",\"lineStyle\":{\"randomLineColor\":\"#80BC42\"},\"parent\":\"root\",\"children\":[{\"id\":\"0e839af3870b\",\"title\":\"无请求量且客户端无调用\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/images/getGrantImage.html\\n/fingerlogin/images/getActivationImage.html\\n/fingerlogin/pad/getPad.html\\n/fingerlogin/pad/getWinStPadList.html\\n/fingerlogin/pad/getOnePadDetail.html\\n/fingerlogin/pad/upPadName.html\\n/fingerlogin/pad/renewPadBatch.html\\n/fingerlogin/group/addPadToGroup.html\\n/fingerlogin/group/getPadList.html\\n/fingerlogin/group/getGroupList_bak.html\\n/fingerlogin/group/delPadfromGroup.html\\n/fingerlogin/config/getUrls.html\\n/fingerlogin/bindPadSms/checkValidata.html\\n/fingerlogin/bindPadSms/sendCode.html\\n/fingerlogin/sms/sendByReset.html\\n/fingerlogin/sms/sendBySignUp.html\\n/fingerlogin/sms/sendByBindUserPhone.html\\n/fingerlogin/sms/sendByBindUserPhoneImg.html\\n/fingerlogin/sms/sendByBindPhoneImg.html\\n/fingerlogin/platform/bindMobile.html\\n/fingerlogin/platform/getUserByThirdAutoXcx.html\\n/fingerlogin/platform/getOpenId.html\\n/fingerlogin/user/checkPadProbation.html\\n/fingerlogin/user/modifyUserInfo.html\\n/fingerlogin/user/sendEmailCode.html\\n/fingerlogin/user/bindPhone.html\\n/fingerlogin/user/getAppId.html\\n/fingerlogin/user/checkVipPad.html\\n/fingerlogin/user/checkPad.html\\n/fingerlogin/user/sendCloudEmailCode.html\\n/fingerlogin/user/getDeviceToken.html\\n/fingerlogin/version/getLatest.html\\n/fingerlogin/version/getPlugin.html\\n/fingerlogin/version/getNewVersion.html\"},{\"id\":\"d864d16e3232\",\"title\":\"设备分组相关\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/group/addGroup.html\\n/fingerlogin/group/delGroup.html\\n/fingerlogin/group/getGroupList.html\\n/fingerlogin/group/movePadToGroup.html\\n/fingerlogin/group/updateGroup.html\"},{\"id\":\"4f6346d8687b\",\"title\":\"图片验证码\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/images/getBindMobileImage.html\\n/fingerlogin/images/getLoginImage.html\\n/fingerlogin/user/getImge.html\\n/fingerlogin/user/getCancelImge.html\"},{\"id\":\"1236dab5017d\",\"title\":\"短信\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/sms/sendByBindPhoneImgRs.html\\n/fingerlogin/sms/sendByCancel.html\\n/fingerlogin/sms/sendByResetImg.html\\n/fingerlogin/sms/sendByResetImgRs.html\\n/fingerlogin/sms/sendBySignUpImg.html\\n/fingerlogin/sms/sendBySignUpImgRs.html\\n/fingerlogin/sms/sendLoginSms.html\"},{\"id\":\"5737b5e9e7f5\",\"title\":\"设备列表、详情\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/group/getWinStPadList.html\\n/fingerlogin/pad/canRenewPadList.html\\n/fingerlogin/pad/getPadList.html\\n/fingerlogin/pad/getPadCount.html\\n/fingerlogin/pad/getPadDetail.html\"},{\"id\":\"c44d2d6fffeb\",\"title\":\"更换设备\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/pad/renewalPad.html\\n/fingerlogin/pad/renewPadBatch.html\"},{\"id\":\"698e82be4fc9\",\"title\":\"注册、登录、注销\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/user/signup.html\\n/fingerlogin/user/signupRs.html\\n/fingerlogin/user/getKey.html\\n/fingerlogin/user/getUser.html\\n/fingerlogin/user/getUserRs.html\\n/fingerlogin/platform/getUserByThirdAuto.html\\n/fingerlogin/user/logout.html\\n/fingerlogin/user/userCancel.html\"},{\"id\":\"6ae98df6a14a\",\"title\":\"修改密码\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/user/resetPasswordRs.html\\n/fingerlogin/user/updatePassword.html\"},{\"id\":\"6e5901903a58\",\"title\":\"版本校验\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/user/checkMend.html\\n/fingerlogin/version/checkNewVersion.html\"},{\"id\":\"69b0a328a23d\",\"title\":\"绑定手机<br>\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/platform/bindMobile.html\\n/fingerlogin/platform/bindMobileRs.html\"},{\"id\":\"22138172a239\",\"title\":\"关闭到期提醒保存\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/pad/saveUserPadDialogLog.html\"},{\"id\":\"cf83d9e33615\",\"title\":\"普通设备申请后功能限时\",\"children\":[],\"parent\":\"c54124d4494e\",\"note\":\"/fingerlogin/pad/getEnableStatus.html\"}]},{\"id\":\"ff1ef081e3bb\",\"title\":\"fingerpay\",\"lineStyle\":{\"randomLineColor\":\"#e85d4e\"},\"parent\":\"root\",\"children\":[{\"id\":\"f4ca6f449c6d\",\"title\":\"支付回调\",\"children\":[],\"parent\":\"ff1ef081e3bb\",\"note\":\"/fingerpay/alipay/notify.html\\n/fingerpay/alipay/notifyWap.html\\n/fingerpay/alipay/return.html\\n/fingerpay/alipay/returnAdvertisingWap.html\\n/fingerpay/alipay/returnWap.html\\n/fingerpay/baidupay/payNotify.html\\n/fingerpay/baidupay/signpaynotify.html\\n/fingerpay/tenpay/notify.html\\n/fingerpay/tenpay/notifyApp.html\\n/fingerpay/tenpay/notifyH5.html\\n/fingerpay/tenpay/notifyIos.html\\n/fingerpay/tenpay/notifyIosAppstore.html\\n/fingerpay/tenpay/notifyIosCaculator.html\\n/fingerpay/tenpay/notifyIosCloundAppstore.html\\n/fingerpay/tenpay/notifyIosNew.html\\n/fingerpay/unionpay/notify.html\\n/fingerpay/unionpay/return.html\\n/fingerpay/wxcspay/androidNotify.html\\n/fingerpay/wxspdpay/androidNotify.html\"},{\"id\":\"833c8ec9d875\",\"title\":\"下单支付\",\"children\":[],\"parent\":\"ff1ef081e3bb\",\"note\":\"/fingerpay/alipay/pay.html\\n/fingerpay/unionpay/pay.html\\n/fingerpay/gateway.html\\n/fingerpay/gatewayV2.html\\n/fingerpay/order/purchaseOrder.html\"},{\"id\":\"4c38af16bfe3\",\"title\":\"微信h5支付订单信息<br>\",\"children\":[],\"parent\":\"ff1ef081e3bb\",\"note\":\"/fingerpay/tenpay/h5/orderquery.html\"},{\"id\":\"7dd9411720df\",\"title\":\"百度续费协议\",\"children\":[],\"parent\":\"ff1ef081e3bb\",\"note\":\"/fingerpay/baidupay/cancelcontract.html\\n/fingerpay/baidupay/checkContractStatus.html\\n/fingerpay/baidupay/contractStatusNotify.html\"}]}],\"note\":\"\"}},\"meta\":{\"id\":\"60ab6c0507912909fabdf710\",\"member\":\"60a739bee0b34d393894cd0c\",\"exportTime\":\"2021-05-25 14:55:03\",\"diagramInfo\":{\"category\":\"mind_free\",\"title\":\"redfinger-gn\",\"created\":\"2021-05-24 17:04:05\",\"creator\":\"60a739bee0b34d393894cd0c\",\"modified\":\"2021-05-25 13:58:32\"},\"type\":\"ProcessOn Schema File\",\"version\":\"1.0\"}}";
        parse(json);
    }

    public static String genId(){
        return RandomUtil.randomString(10);
    }

}
