use std::io;
fn main() {
    let mut line = String::new();
    io::stdin().read_line(&mut line).unwrap();
    line.split_whitespace()
        .map(|val_str| val_str.parse::<i32>())
}
