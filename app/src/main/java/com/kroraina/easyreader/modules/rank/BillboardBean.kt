package com.kroraina.easyreader.modules.rank

/**
 * Created on 17-4-23.
 * 排行榜
 */

class BillboardBean(var title: String?) {
    var _id: String? = null
    var cover: String? = null
    var isCollapse: Boolean = false
    var monthRank: String? = null
    var totalRank: String? = null
}