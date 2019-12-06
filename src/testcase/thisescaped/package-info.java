package testcase.thisescaped;
/**
 *
 *
 * 对象的 this引用逸出.
 * 发生条件
 * 1· 在构造方法中创建内部类
 * 2. 将这个内部类发布出去
 * 由于内部类可以直接持有外部类的this引用，在构造时发生了上下文切换，导致数据的不一致性
 *
 * 解决办法
 *
 *
 *
 *
 *
 *
 *
 * */




