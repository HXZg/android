package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.HomeBean
import com.micropole.homemodule.util.changeKm
import com.micropole.homemodule.util.loadImg

/**
 * @ClassName       HomeHouseAdapter
 * @Description     首页为您推荐
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 16:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomeHouseAdapter : BaseQuickAdapter<HomeBean.ProjectBean,BaseViewHolder>(R.layout.item_house_view){
    override fun convert(helper: BaseViewHolder?, item: HomeBean.ProjectBean?) {
        helper?.run {
            loadImg(R.id.iv_house_img,item?.h_imgs)
            setText(R.id.tv_house_name,item?.h_title)
            setText(R.id.tv_house_address,item?.h_address)
            setText(R.id.tv_house_des,"距离${item?.distance?.changeKm()}  ${item?.room_hall}  ${item?.area_name}")
            setText(R.id.tv_house_price,"${item?.h_price}元/天")
            setText(R.id.tv_house_score,item?.comment_score)
            setVisible(R.id.stv_house_deposit,item?.deposit_free == "1")
        }
    }
}