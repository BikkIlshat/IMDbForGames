package com.github.bikkIlshat.mdbforgames.model.base

/***
 * Базовый interface (любой элемент списка который отправляется в recyclerView в adapter  он должен быть наследником ListItem
 * Все ListItem должны иметь id что бы могли отличаться - что бы во всех списках каждый  Item любого списка имел свой уникальный id
 * который нам поможет правильно работать с Diffutils
 * Чаще всего этот id будет совпадать с id структуры которую мы используем например id Игры в списке
 */
interface ListItem {
  val itemId: Long
}

