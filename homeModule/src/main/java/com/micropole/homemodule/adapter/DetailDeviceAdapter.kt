package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.HouseDetailBean
import com.micropole.homemodule.util.loadImg

/**
 * @ClassName       DetailDeviceAdapter
 * @Description     房间设施
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 16:25
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class DetailDeviceAdapter : BaseQuickAdapter<HouseDetailBean.FacilityServicesArrBean,BaseViewHolder>(R.layout.item_device_view) {
    override fun convert(helper: BaseViewHolder?, item: HouseDetailBean.FacilityServicesArrBean?) {
        helper?.run {
            loadImg(R.id.iv_device_img,item?.area_img)
            setText(R.id.tv_device_name,item?.area_name)
        }
    }
}