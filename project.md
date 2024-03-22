## Login Menu

#### register [username] [password]
+ register successful

- a user exists with this username

#### register as admin [username] [password]
+ admin user created successfully
- admin user already created
- a user exists with this username

#### login [username] [password]
+ login successful
- no user exists with this username
- incorrect password

#### change password [username] [old password] [new password]
+ password changed successfully
- no user exists with this username
- incorrect password
- new password format is invalid
- new password is weak

#### remove account [username] [password]
+ account removed successfully
- no user exists with this username
- incorrect password

#### exit

## Main Menu

#### admin menu
+ entered admin menu
- you don't have access to this menu

#### customer menu
+ entered custumer menu
- you don't have access to this menu

#### logout
+ logout successful

## Admin Menu

#### add airplane [name] [capacity]
+ plane created successfully
- an airplane exists with this name
- invalid capacity

#### add flight [origin] [destination] [date] [airplane's name] [ticket price]
+ flight created successfully
- no airplane exists with this name
- invalid ticket price
- This aircraft already has a flight on this date

#### show all flights
+ [number]- [origin]->[destination] [date] [airplane's name] [ticket price]
- nothing

#### show flights on [date]
+ [number]- [origin]->[destination] [date] [airplane's name] [ticket price]
- nothing

#### show airplanes
+ [number]- [airplane's name] : [number of flights]
- nothing

#### show balance

#### back

## Custumer Menu

#### purchase ticket [origin] [destination]

+ [number]- [date] [airplane's name] [ticket price]
    + number
    - end
+ purchase successful
- invalid command!
- invalid number
- no empty seat
- you don't have enough money
- There is no direct flight from [origin] to [destination]
    + [number]- [origin]->[third city] [date] [ticket price] | [third city]->[destination] [date] [ticket price]
        + number
        - end

#### charge account [amount]
+ account charged successfully
- invalid amount

#### cancel ticket
+ [number]- [origin]->[destination] [date] [ticket price]
    + number
    - end
+ cancel successful
- you don't have any tickets

#### show balance

#### back