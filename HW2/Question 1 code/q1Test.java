// Loay Shqair, 202365030
public class q1Test {
    public static void main(String[] args) {
        CDLList<Integer> cdll = new CDLList<>();

        // Note that the behaviour of the add and delete methods differs depending on whether the cdll was reversed or not
        // this was done to maintain an ordered cdll as requested in the assignment
        int[] nums1 = {2, 6, 1, 6, 4, 7, 0};
        int[] nums2 = {-5, -1, 4, 6, 17};

        for (int num : nums1)
            cdll.add(num);
        System.out.println("cdll added to");
        cdll.display();

        System.out.println("Size of cdll is");
        System.out.println(cdll.size());

        cdll.reverse();
        System.out.println("cdll reversed");
        cdll.display();

        System.out.println("Middle element of cdll is");
        System.out.println(cdll.findMiddle());

        for (int num : nums2)
            cdll.add(num);
        System.out.println("cdll added to");
        cdll.display();

        System.out.println("Middle element of cdll is");
        System.out.println(cdll.findMiddle());

        cdll.reverse();
        System.out.println("cdll reversed");
        cdll.display();

        for (int num : nums1)
            cdll.delete(num);
        System.out.println("cdll deleted from");
        cdll.display();

        System.out.println("Size of cdll is");
        System.out.println(cdll.size());

        cdll.reverse();
        System.out.println("cdll reversed");
        cdll.display();

        System.out.println("Middle element of cdll is");
        System.out.println(cdll.findMiddle());

        System.out.println("Size of cdll is");
        System.out.println(cdll.size());

        for (int num : nums2)
            cdll.delete(num);

        System.out.println("cdll deleted from");
        cdll.display();

        System.out.println("Middle element of cdll is");
        System.out.println(cdll.findMiddle());

        System.out.println("Size of cdll is");
        System.out.println(cdll.size());

    }
}
