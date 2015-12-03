  my_number = rand(10)
  puts('Pick a number between 1 and 10')

  their_number = gets.to_i

  while my_number != their_number
    if their_number > my_number then
      puts 'Too high. Guess again.'
    else
      puts 'Too low. Guess again.'
    end

    their_number = gets.to_i
  end

  puts 'Got it!'
