package org.learnit.primitivetypes;

/**
 * Integer类型计算测试02
 * @Description 为什么short、byte会被提升为int？
 * 答： 这个问题确实和Java虚拟机的指令集有关系
 * Java虚拟机的`指令`由[一个字节长度的、代表着某种特定操作含义的数字（称为操作码，Opcode）| 以及跟随其后的零至多个代表次操作所需参数（称为操作数，Operands）]而构成。
 * Java虚拟机的指令集中的大多数都对它们执行的操作的数据类型进行编码，
 * 例如 iload 指令，是将一个局部变量加载到操作栈，且这个局部变量必须是 int 类型，每一个指令都是只能接受对应类型的数据的
 * 但由于操作码(Opcode)的长度为一个字节，这意味着指令集的操作码总数不可能超过256条
 * (因为：如果每一种与数据类型相关的指令都支持Java虚拟机所有运行时数据类型的话，那指令的数量就会超出一个字节所能表示的数量范围了)
 *
 * 参考res/Table_Type_support_in_the_JVM_instruction_set.png, 可以发现大部分指令都没有支持 byte、char 和 short 类型，甚至没有任何指令支持 boolean 类型
 * 因此如果要对两个 short 类型的数字相加，那只能转成 int，再使用 iadd 命令相加，然后再转成 short 了
 *
 * @Reference 参考https://cloud.tencent.com/developer/news/735870
 * @author wangzhuo
 */
public class TestInteger02 {

    public static void main(String[] args) {
        short a = 1;
        short b = 2;
        short d = (short) (a + b);

        int ii;
        Integer i = new Integer(1);
        ii = i;

        String t1 = "12345";
        String t2 = "12" + new String("345");
        System.out.println(String.format("t1 == t2 >> %s", t1 == t2));

        int c = a + b;

        // short类型a 和 short类型b 都先转换为int 再参与运算
        //short d = a + b; //编译器报错

        // 一次减法计算
        System.out.println(String.format("一次减法计算: %s", a - b));
        // 两次次减法计算
        System.out.println(String.format("两次次减法计算: %s", a - b - c));
        // 多次次减法计算
        System.out.println(String.format("两次次减法计算: %s", a - (b - c)));
    }
}