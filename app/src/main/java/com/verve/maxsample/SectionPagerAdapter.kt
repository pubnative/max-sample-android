package com.verve.maxsample

import android.app.Activity
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import androidx.viewpager.widget.PagerAdapter

class SectionPagerAdapter(private val activity: Activity) : PagerAdapter() {

    private val sections = mutableListOf<ContentSection>()
    private var recycledViewPool = RecycledViewPool()
    private var views = SparseArray<View>()

    init {
        val item1 = ContentItem(0, "Item 1")
        val item2 = ContentItem(1, "Item 2")
        val item3 = ContentItem(2, "Item 3")
        val item4 = ContentItem(3, "Item 4")
        val item5 = ContentItem(4, "Item 5")
        val item6 = ContentItem(5, "Item 6")
        val item7 = ContentItem(6, "Item 7")
        val item8 = ContentItem(7, "Item 8")
        val item9 = ContentItem(8, "Item 9")
        val item10 = ContentItem(9, "Item 10")
        val item11 = ContentItem(10, "Item 11")
        val item12 = ContentItem(11, "Item 12")
        val item13 = ContentItem(12, "Item 13")
        val item14 = ContentItem(13, "Item 14")
        val item15 = ContentItem(14, "Item 15")
        val item16 = ContentItem(15, "Item 16")
        val item17 = ContentItem(16, "Item 17")
        val item18 = ContentItem(17, "Item 18")
        val item19 = ContentItem(18, "Item 19")
        val item20 = ContentItem(19, "Item 20")
        val item21 = ContentItem(20, "Item 21")
        val item22 = ContentItem(21, "Item 22")
        val item23 = ContentItem(22, "Item 23")
        val item24 = ContentItem(23, "Item 24")
        val item25 = ContentItem(24, "Item 25")
        val item26 = ContentItem(25, "Item 26")
        val item27 = ContentItem(26, "Item 27")
        val item28 = ContentItem(27, "Item 28")
        val item29 = ContentItem(28, "Item 29")
        val item30 = ContentItem(29, "Item 30")
        val item31 = ContentItem(30, "Item 31")
        val item32 = ContentItem(31, "Item 32")
        val item33 = ContentItem(32, "Item 33")
        val item34 = ContentItem(33, "Item 34")
        val item35 = ContentItem(34, "Item 35")

        val itemList1 = mutableListOf(
            item1,
            item2,
            item3,
            item4,
            item5,
            item6,
            item7,
            item8,
            item9,
            item10,
            item11,
            item12,
            item13,
            item14,
            item15
        )
        val itemList2 = mutableListOf(item16, item17, item18, item19)
        val itemList3 = mutableListOf(
            item20,
            item21,
            item22,
            item23,
            item24,
            item25,
            item26,
            item27,
            item28,
            item29,
            item30,
            item31
        )
        val itemList4 = mutableListOf(item32, item33, item34)
        val itemList5 = mutableListOf(item35)

        sections.add(ContentSection(0, "Section 1", itemList1))
        sections.add(ContentSection(1, "Section 2", itemList2))
        sections.add(ContentSection(2, "Section 3", itemList3))
        sections.add(ContentSection(3, "Section 4", itemList4))
        sections.add(ContentSection(4, "Section 5", itemList5))
    }


    override fun getCount() = sections.size

    override fun isViewFromObject(view: View, obj: Any) = view == obj

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = SectionView(activity)
        view.setRecycledViewPool(recycledViewPool)
        views.put(position, view)
        view.setTabTagAndHelper(sections[position], position)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        if (obj is SectionView) {
            obj.clear()
            container.removeView(obj)
            views.remove(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return sections[position].title
    }

    override fun getItemPosition(obj: Any): Int {
        return POSITION_NONE
    }
}