package com.github.bikkIlshat.mdbforgames.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.github.bikkIlshat.mdbforgames.model.base.ListItem

open class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<ListItem>() {
  //проверка что старый Item и новый Item в списке это один и тот же Item
  // чаще всего это сравнение происходит по id
  override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
    // нам надо в в DIFF_CALLBACK теперь указать  используя id что данные у нас как-то отличаются
    oldItem.itemId == newItem.itemId

  // Должен вернуть true или false в зависимости от того  равны ли по контенту ваши элементы
  // если вы тут возвращаете true то Update этого Item не произойдет если же вернём false то этот Item обновистся
  override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
    //  тут нужно сравнить именно, что контент изменился (этот метод будет вызываться если fun areItemsTheSame вернёт true)
    return oldItem.equals(newItem)
  }
}