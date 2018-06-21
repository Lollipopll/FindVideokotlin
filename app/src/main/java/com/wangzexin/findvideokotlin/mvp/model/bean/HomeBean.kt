package com.wangzexin.findvideokotlin.mvp.model.bean
import com.google.gson.annotations.SerializedName


/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe
 */


data class DailyBean(
		@SerializedName("issueList") val issueList: List<Issue> = listOf(),
		@SerializedName("nextPageUrl") val nextPageUrl: String = "",
		@SerializedName("nextPublishTime") val nextPublishTime: Long = 0,
		@SerializedName("newestIssueType") val newestIssueType: String = "",
		@SerializedName("dialog") val dialog: Any = Any()
)

data class Issue(
		@SerializedName("releaseTime") val releaseTime: Long = 0,
		@SerializedName("type") val type: String = "",
		@SerializedName("date") val date: Long = 0,
		@SerializedName("publishTime") val publishTime: Long = 0,
		@SerializedName("itemList") val itemList: List<Item> = listOf(),
		@SerializedName("count") val count: Int = 0
)

data class Item(
		@SerializedName("type") val type: String = "",
		@SerializedName("data") val data: Data = Data(),
		@SerializedName("tag") val tag: Any = Any(),
		@SerializedName("id") val id: Int = 0,
		@SerializedName("adIndex") val adIndex: Int = 0
)

data class Data(
		@SerializedName("dataType") val dataType: String = "",
		@SerializedName("id") val id: Int = 0,
		@SerializedName("title") val title: String = "",
		@SerializedName("description") val description: String = "",
		@SerializedName("image") val image: String = "",
		@SerializedName("actionUrl") val actionUrl: String = "",
		@SerializedName("adTrack") val adTrack: Any = Any(),
		@SerializedName("shade") val shade: Boolean = false,
		@SerializedName("label") val label: Any = Any(),
		@SerializedName("labelList") val labelList: Any = Any(),
		@SerializedName("header") val header: Any = Any()
)