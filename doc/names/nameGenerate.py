# Random name generator
import os
import system

male_name_file = open(r"male","r")
female_name_file = open(r"female","r")
male_list = male_name_file.readLines()
female_list = female_name_file.readLines()
all_names = male_list + female_list

def new_name():
    print("Name: {}".format(random.choice(all_names))
    os.system("pause")


if __name__ == '__main__':
    new_name()