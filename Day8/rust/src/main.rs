#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

struct Solution {}

fn main() {
    println!("Hello, world!");
}

impl Solution {
    pub fn middle_node(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if let None = head {
            return None;
        }
        match head.as_ref() {
            Some(node) => {
                if let None = node.next {
                    return head;
                }
            }
            _ => {
                return None;
            }
        }
        let mut faster = head.as_ref();
        let mut slower = head.as_ref();
        loop {
            if let None = faster {
                // slower = slower.unwrap().next.as_ref();
                break;
            }
            if let None = faster.unwrap().next.as_ref() {
                break;
            }
            faster = faster.unwrap().next.as_ref().unwrap().next.as_ref();
            slower = slower.unwrap().next.as_ref();
        }
        let toReturn = Some(slower.unwrap().clone());
        // println!("ans: {:?}", toReturn);
        toReturn
        // Some(Box::new(ListNode::new(0)))
    }
}
