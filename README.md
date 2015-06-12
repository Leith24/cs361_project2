UTEID: gdl386, dao384
FIRSTNAME: Gavin, Daniel
LASTNAME: Leith, Olvera
CSACCOUNT: gavindl, dolvera1
EMAIL: gavinleith@utexas.edu, daolvera1@gmail.com

In our code, we create a simple Secure System that manages two subjects - Hal and Lyle - and two objects - Lobj and Hobj - that hold either a high security label or a low security label. Our code brings in an instruction list that details a series of instructions that will be carried out by our Secure System. At this point, only READ and WRITE instructions are supported. Anything that is not a READ or a WRITE is labelled as a bad instruction and will not be executed by our System. If the instruction is valid, we also check the legality of the READ or WRITE based on the Simple Security Property and the *-property. After these insturctions are executed, we print out the current state of the system based on the previously run instruction.

We have finished all the requirements.
Test Case 1 Input:

CHECK FOR DIFFERING BAD INSTRUCTIONS
make Hal MObj 32
find Lyle MObj
How is the weather today?
create Hal MObj 32
locate Hal MObj
write Lyle LObj 11
read Hal LObj
Are you sure you created the MObj, Hal?
write Lyle HObj 32
read Lyle HObj
read Hal HObj

output in testCase1Out

Test Case 2 Input:

Test for incorrect write
read Hal HObj
write Lyle HObj abc
write Lyle LObj def
read Hal LObj
read Lyle HObj
write Hal LObj 44
write Lyle HObj 3
reader Hal HObj
writer Lyle LObj 2
read Lyle LObj

Output in testCase2Out

Test Case 3 Input:
TESTING FOR CAPS LOCK
WRITE HAL HOBJ 9000
WRITE LYLE LOBJ 444
READ HAL LOBJ
READ LYLE LOBJ
READ HAL HOBJ
I THINK WE DID IT

Output in testCase3Out

We made 3 extra test cases, bringing our total to 4 including the instructionList case.