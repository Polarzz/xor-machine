#include <iostream>
#include <fstream> 
int main(int argc, char *argv[]) {
    if(argc > 1) {
        std::ifstream file (argv[1]);
        std::string program;
        getline(file, program, (char) file.eof());
        bool a, b = false;
        int loop = 0;
        for(char& curr : program) {
            loop++;
            char next = program[loop];
            if (curr == 'a' && next == 'a') {
                a = (a && !a) || (!a && a);
            } else if (curr == 'a' && next == 'b') {
                a = (a && !b) || (!a && b);
            } else if (curr == 'a' && next == '1') {
                a = (a && !true) || (!a && true);
            } else if (curr == 'b' && next == 'a') {
                b = (b && !a) || (!b && a);
            } else if (curr == 'b' && next == 'b') {
                b = (b && !b) || (!b && b);
            } else if (curr == 'b' && next == '1') {
                b = (b && !true) || (!b && true);
            }
            
        }
        std::cout << ((int) a > (int) b);

    } else {
        std::cout << "No arguments supplied.\n";
    }
    return 0;
}
